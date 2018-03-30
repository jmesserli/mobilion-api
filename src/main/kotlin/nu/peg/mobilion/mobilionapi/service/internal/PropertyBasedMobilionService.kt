package nu.peg.mobilion.mobilionapi.service.internal

import nu.peg.mobilion.mobilionapi.config.MobilionProperties
import nu.peg.mobilion.mobilionapi.model.MobilionValue
import nu.peg.mobilion.mobilionapi.service.MobilionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PropertyBasedMobilionService @Autowired constructor(
        private val mobilionProperties: MobilionProperties
) : MobilionService {


    override fun getMobilionValue(): MobilionValue {
        return MobilionValue(mobilionProperties.value)
    }
}