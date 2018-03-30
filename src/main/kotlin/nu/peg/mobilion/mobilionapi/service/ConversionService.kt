package nu.peg.mobilion.mobilionapi.service

import nu.peg.mobilion.mobilionapi.model.MobilionConversion

interface ConversionService {
    fun convertToMobilion(value: Double): MobilionConversion
}