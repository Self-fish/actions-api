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
class KafkaProducerExample {

    private val KAFKA_TOPIC = "aquarium_actions"
    private val BOOTSTRAP_SERVER = "192.168.0.15:9092"

    private fun createProducer(): Producer<Long, String> {
        val props = Properties()
        props.put(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            BOOTSTRAP_SERVER
        )
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer")
        props.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            LongSerializer::class.java.name
        )
        props.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            StringSerializer::class.java.name
        )
        return KafkaProducer(props)
    }

    @Throws(Exception::class)
    fun runProducer(sendMessageCount: Int) {
        System.out.println("Kafka Producer - Sending action: ")
        val producer = createProducer()
        val time = System.currentTimeMillis()
        try {
            for (index in time until time + sendMessageCount) {
                val record = ProducerRecord(
                    KAFKA_TOPIC, index,
                    "Hello Mom $index"
                )
                val metadata = producer.send(record).get()
                val elapsedTime = System.currentTimeMillis() - time
                System.out.printf(
                    """
                        sent record(key=%s value=%s) meta(partition=%d, offset=%d) time=%d
                        
                        """.trimIndent(),
                    record.key(), record.value(), metadata.partition(),
                    metadata.offset(), elapsedTime
                )
            }
        } finally {
            producer.flush()
            producer.close()
        }
    }

}