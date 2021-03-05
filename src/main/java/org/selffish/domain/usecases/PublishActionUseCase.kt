package org.selffish.domain.usecases

import org.selffish.domain.contracts.ActionsRepository
import org.selffish.domain.entities.CustomAction
import org.springframework.stereotype.Service

@Service
class PublishActionUseCase(private val repository: ActionsRepository) {

    fun publish(action: CustomAction): CustomAction {
        repository.processAction(action)
        return action
    }


}