package org.selffish.framework

import org.selffish.domain.entities.ActionEvent
import org.selffish.domain.usecases.PublishActionUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("actions")
class ActionsController(private val publishAction: PublishActionUseCase) {

    @RequestMapping(method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody actionEvent: ActionEvent): ActionEvent {
        return publishAction.publish(actionEvent)
    }

}