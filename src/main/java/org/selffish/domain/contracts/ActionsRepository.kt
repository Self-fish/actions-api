package org.selffish.domain.contracts

import ActionEvent

interface ActionsRepository {

    fun processAction(action: ActionEvent)
}