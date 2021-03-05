package org.selffish.adapters.data

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.LongSerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomKafkaProducer {

    companion object {
        private const val KAFKA_TOPIC = "aquarium_actions"
        private const val BOOTSTRAP_SERVER = "192.168.0.15:9092"
    }


    private fun createProducer(): Producer<Long, String> {
        val props = Properties()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVER
        props[ProducerConfig.CLIENT_ID_CONFIG] = "CustomKafkaProducer"
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = LongSerializer::class.java.name
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        return KafkaProducer(props)
    }

    @Throws(Exception::class)
    fun runProducer(sendMessageCount: Int) {
        val producer = createProducer()
        val time = System.currentTimeMillis()
        try {
            val record = ProducerRecord(KAFKA_TOPIC, time, "This is a custom message")
            producer.send(record).get()
        } finally {
            producer.flush()
            producer.close()
        }
    }

}