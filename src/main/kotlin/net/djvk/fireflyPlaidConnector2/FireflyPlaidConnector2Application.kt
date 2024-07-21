package net.djvk.fireflyPlaidConnector2

import io.micrometer.core.instrument.MeterRegistry
import net.djvk.fireflyPlaidConnector2.sync.Runner
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Profile
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener

@Profile("!test")
@ConfigurationPropertiesScan(basePackages = ["net.djvk.fireflyPlaidConnector2.config.properties"])
@SpringBootApplication
class FireflyPlaidConnector2Application(
    private val runner: Runner,
    private val meterRegistry: MeterRegistry,
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @EventListener(ApplicationReadyEvent::class)
    fun appReady() {
        /**
         * We're doing this here rather than in a bean init function or @PostConstruct to avoid
         *  things being launched automatically, thus making them easier to test
         */
        runner.run()
    }

    @EventListener(ContextClosedEvent::class)
    fun onExit() {
        meterRegistry.close()
        logger.debug("MeterRegistry has been closed")
    }
}

fun main(args: Array<String>) {
    runApplication<FireflyPlaidConnector2Application>(*args)
}
