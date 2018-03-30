package nu.peg.mobilion.mobilionapi.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.ResourceSupport

data class MobilionConversion @JsonCreator constructor(
        @JsonProperty("original") val original: Double,
        @JsonProperty("mobilionValue") val mobilionValue: Double
) : ResourceSupport()