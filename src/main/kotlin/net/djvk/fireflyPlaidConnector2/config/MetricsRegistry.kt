package net.djvk.fireflyPlaidConnector2.config

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import net.djvk.fireflyPlaidConnector2.config.properties.MetricsConfig
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
data class MetricsRegistry(val config: MetricsConfig) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun getMeterRegistry(): MeterRegistry {
        val registry = SimpleMeterRegistry()
        if (config.tags != null) {
            logger.info("Tagging metrics with: {}", config.tags)
            registry.config().commonTags(config.tags!!.asSequence().map { Tag.of(it.key, it.value) }.toList())
        }
        JvmMemoryMetrics().bindTo(registry)
        return registry
    }
}