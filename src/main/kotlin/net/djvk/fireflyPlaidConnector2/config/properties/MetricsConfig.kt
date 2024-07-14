package net.djvk.fireflyPlaidConnector2.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "metrics")
data class MetricsConfig(
    val tags: Map<String, String>?,
)