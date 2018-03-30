package nu.peg.mobilion.mobilionapi.service

import nu.peg.mobilion.mobilionapi.model.MobilionValue

interface MobilionService {
    fun getMobilionValue(): MobilionValue
}