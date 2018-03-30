package nu.peg.mobilion.mobilionapi.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "mobilion")
class MobilionProperties {
    var value: Double = 0.0
}