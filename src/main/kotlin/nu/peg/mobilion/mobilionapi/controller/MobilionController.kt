package nu.peg.mobilion.mobilionapi.controller

import nu.peg.mobilion.mobilionapi.model.MobilionConversion
import nu.peg.mobilion.mobilionapi.model.MobilionValue
import nu.peg.mobilion.mobilionapi.service.ConversionService
import nu.peg.mobilion.mobilionapi.service.MobilionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MobilionController @Autowired constructor(
        private val mobilionService: MobilionService,
        private val conversionService: ConversionService
) {

    @GetMapping("/")
    fun index(): HttpEntity<ResourceSupport> {
        val support = ResourceSupport()
        support.add(linkTo(methodOn(MobilionController::class.java).index()).withSelfRel())
        support.add(linkTo(methodOn(MobilionController::class.java).getValue()).withRel("value"))
        support.add(linkTo(methodOn(MobilionController::class.java).convertToMobilion(0.0)).withRel("convert"))

        return ResponseEntity(support, HttpStatus.OK)
    }

    @GetMapping("/value")
    fun getValue(): HttpEntity<MobilionValue> {
        val value = mobilionService.getMobilionValue()
        value.add(linkTo(methodOn(MobilionController::class.java).index()).withRel("index"))
        value.add(linkTo(methodOn(MobilionController::class.java).getValue()).withSelfRel())

        return ResponseEntity(value, HttpStatus.OK)
    }

    @GetMapping("/convert")
    fun convertToMobilion(@RequestParam("value", required = true) value: Double): HttpEntity<MobilionConversion> {
        val conversion = conversionService.convertToMobilion(value)
        conversion.add(linkTo(methodOn(MobilionController::class.java).index()).withRel("index"))
        conversion.add(linkTo(methodOn(MobilionController::class.java).convertToMobilion(value)).withSelfRel())

        return ResponseEntity(conversion, HttpStatus.OK)
    }
}