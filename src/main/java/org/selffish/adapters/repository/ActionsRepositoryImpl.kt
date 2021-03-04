package org.selffish.adapters.repository

import ActionEvent
import org.selffish.adapters.data.KafkaProducerExample
import org.selffish.domain.contracts.ActionsRepository
import org.springframework.stereotype.Service

@Service
class ActionsRepositoryImpl(private val producer: KafkaProducerExample): ActionsRepository {

    override fun processAction(action: ActionEvent) {
        producer.runProducer(5)
    }
}