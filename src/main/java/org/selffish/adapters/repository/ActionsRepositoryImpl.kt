package org.selffish.adapters.repository

import org.selffish.adapters.data.SocketClient
import org.selffish.domain.contracts.ActionsRepository
import org.selffish.domain.entities.CustomAction
import org.springframework.stereotype.Service

@Service
class ActionsRepositoryImpl(private val socketClient: SocketClient): ActionsRepository {

    override fun processAction(action: CustomAction) {
        socketClient.sendMessage(action.step.name, action.action)
    }
}