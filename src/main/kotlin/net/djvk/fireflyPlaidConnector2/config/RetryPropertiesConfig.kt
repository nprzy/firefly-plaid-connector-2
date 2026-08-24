package net.djvk.fireflyPlaidConnector2.config

import net.djvk.fireflyPlaidConnector2.api.RetryProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Binds [RetryProperties] twice, at two different config prefixes, so Plaid and Firefly retry
 * behavior can be tuned independently while sharing the same knob names.
 */
@Configuration
class RetryPropertiesConfig {
    @Bean
    @ConfigurationProperties(prefix = "fireflyPlaidConnector2.plaid.retry")
    fun plaidRetryProperties(): RetryProperties = RetryProperties()

    @Bean
    @ConfigurationProperties(prefix = "fireflyPlaidConnector2.firefly.retry")
    fun fireflyRetryProperties(): RetryProperties = RetryProperties()
}
