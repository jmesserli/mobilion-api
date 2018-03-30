package nu.peg.mobilion.mobilionapi.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.ResourceSupport

data class MobilionValue @JsonCreator constructor(
        @JsonProperty("value") var value: Double
) : ResourceSupport() {
}