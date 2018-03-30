package nu.peg.mobilion.mobilionapi.controller

import nu.peg.mobilion.mobilionapi.model.MobilionValue
import nu.peg.mobilion.mobilionapi.service.MobilionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MobilionController @Autowired constructor(
        private val mobilionService: MobilionService
) {

    @GetMapping("/")
    fun index(): HttpEntity<ResourceSupport> {
        val support = ResourceSupport()
        support.add(linkTo(methodOn(MobilionController::class.java).index()).withSelfRel())
        support.add(linkTo(methodOn(MobilionController::class.java).getValue()).withRel("value"))

        return ResponseEntity(support, HttpStatus.OK)
    }

    @GetMapping("/value")
    fun getValue(): HttpEntity<MobilionValue> {
        val value = mobilionService.getMobilionValue()
        value.add(linkTo(methodOn(MobilionController::class.java).index()).withRel("index"))
        value.add(linkTo(methodOn(MobilionController::class.java).getValue()).withSelfRel())

        return ResponseEntity(value, HttpStatus.OK)
    }

}