package nu.peg.mobilion.mobilionapi.service.internal

import nu.peg.mobilion.mobilionapi.model.MobilionConversion
import nu.peg.mobilion.mobilionapi.service.ConversionService
import nu.peg.mobilion.mobilionapi.service.MobilionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DefaultConversionService @Autowired constructor(
        private val mobilionService: MobilionService
) : ConversionService {
    override fun convertToMobilion(value: Double): MobilionConversion {
        val mobilionValue = mobilionService.getMobilionValue()
        val converted = value / mobilionValue.value

        return MobilionConversion(value, converted)
    }
}