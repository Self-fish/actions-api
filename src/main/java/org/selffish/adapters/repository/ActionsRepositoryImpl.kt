package org.selffish.adapters.repository

import org.selffish.adapters.data.KafkaProducerExample
import org.selffish.domain.contracts.ActionsRepository
import org.selffish.domain.entities.ActionEvent
import org.springframework.stereotype.Service

@Service
class ActionsRepositoryImpl(private val producer: KafkaProducerExample): ActionsRepository {

    override fun processAction() {
        System.out.println("Repository - Sending action: ")
        producer.runProducer(5)
    }
}