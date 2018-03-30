package nu.peg.mobilion.mobilionapi

import nu.peg.mobilion.mobilionapi.config.MobilionProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(MobilionProperties::class)
class MobilionApiApplication

fun main(args: Array<String>) {
    runApplication<MobilionApiApplication>(*args)
}
