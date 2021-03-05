package org.selffish.domain.contracts

import org.selffish.domain.entities.CustomAction


interface ActionsRepository {

    fun processAction(action: CustomAction)
}