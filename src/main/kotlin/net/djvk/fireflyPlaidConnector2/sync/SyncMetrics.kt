package net.djvk.fireflyPlaidConnector2.sync

import io.micrometer.core.instrument.*
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.String.join

private val DELIMITER = "."

@Component
class SyncMetrics(private val registry: MeterRegistry) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        if (registry is SimpleMeterRegistry) {
            logger.info("No Micrometer metrics connector configured. Simple metrics will be printed via the logger.")
        } else {
            logger.info("Shipping metrics using {}", registry.javaClass)
        }
    }

    enum class RequestType(val metricPrefix: String, val description: String) {
        PLAID_TX_SYNC("plaid.transaction.sync", "Plaid transaction sync"),
        FIREFLY_TX_LIST("firefly.transaction.list", "Firefly transaction list"),
        FIREFLY_TX_STORE("firefly.transaction.store", "Firefly transaction store"),
        FIREFLY_TX_UPDATE("firefly.transaction.update", "Firefly transaction update"),
        FIREFLY_TX_DELETE("firefly.transaction.delete", "Firefly transaction delete"),
    }

    val plaidSyncCreated = DistributionSummary
        .builder(join(DELIMITER, RequestType.PLAID_TX_SYNC.metricPrefix, "created"))
        .description("Number of created transactions returned by Plaid's transaction sync operation")
        .register(registry)
    val plaidSyncUpdated = DistributionSummary
        .builder(join(DELIMITER, RequestType.PLAID_TX_SYNC.metricPrefix, "updated"))
        .description("Number of updated transactions returned by Plaid's transaction sync operation")
        .register(registry)
    val plaidSyncDeleted = DistributionSummary
        .builder(join(DELIMITER, RequestType.PLAID_TX_SYNC.metricPrefix, "deleted"))
        .description("Number of deleted transactions returned by Plaid's transaction sync operation")
        .register(registry)

    val pollRunnerExecTime = Timer.builder("runner.time")
        .tags("class", "PolledSyncRunner")
        .description("Time taken for the runner to perform a single sync of all accounts")
        .register(registry)

    fun startTimer(): Timer.Sample {
        return Timer.start(registry)
    }

    suspend fun <T> measureRequest(type: RequestType, block: suspend () -> T): T {
        val timeSample = Timer.start(registry)
        var exception: RuntimeException? = null
        try {
            return block()
        } catch (e: RuntimeException) {
            exception = e
            throw e
        } finally {
            val timer = getRequestTimer(type, exception)
            timeSample.stop(timer)
        }
    }

    fun printMetrics() {
        if (registry is SimpleMeterRegistry) {
            logger.info(registry.metersAsString)
        }
    }

    // Per guidance from the Micrometer docs, avoid initializing Meter instances on each use. This will memoize the
    // ones that we've already used for quicker lookup.
    // https://docs.micrometer.io/micrometer/reference/concepts/registry.html
    private val requestTimers = hashMapOf<Pair<RequestType, Class<Any>?>, Timer>()
    private fun getRequestTimer(type: RequestType, exception: RuntimeException?): Timer {
        return requestTimers.computeIfAbsent(Pair(type, exception?.javaClass)) {
            Timer.builder(join(DELIMITER, type.metricPrefix, "time"))
                .description("Timing of network requests to " + type.description)
                .tags(listOf(Tag.of("result", if (exception == null) "success" else exception.javaClass.simpleName)))
                .publishPercentileHistogram(true) // Publish full histogram to backends that support it
                .publishPercentiles(0.5, 0.95) // Compute client-side percentiles for backends that don't support the above
                .register(registry)
        }
    }
}