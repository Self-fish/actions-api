package org.selffish.adapters.repository

import org.selffish.adapters.data.CustomKafkaProducer
import org.selffish.domain.contracts.ActionsRepository
import org.selffish.domain.entities.CustomAction
import org.springframework.stereotype.Service

@Service
class ActionsRepositoryImpl(private val producer: CustomKafkaProducer): ActionsRepository {

    override fun processAction(action: CustomAction) {
        producer.runProducer(5)
    }
}