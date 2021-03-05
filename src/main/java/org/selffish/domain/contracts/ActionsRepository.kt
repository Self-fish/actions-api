package org.selffish.domain.contracts

import org.selffish.domain.entities.ActionEvent


interface ActionsRepository {

    fun processAction(action: ActionEvent)
}