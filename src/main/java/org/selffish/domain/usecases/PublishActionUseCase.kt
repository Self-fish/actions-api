package org.selffish.domain.usecases

import org.selffish.domain.contracts.ActionsRepository
import org.selffish.domain.entities.ActionEvent
import org.springframework.stereotype.Service

@Service
class PublishActionUseCase(private val repository: ActionsRepository) {

    fun publish(action: ActionEvent): ActionEvent {
        System.out.println("Use case - Sending action: " + action.action.name)
        repository.processAction(action)
        return action
    }


}