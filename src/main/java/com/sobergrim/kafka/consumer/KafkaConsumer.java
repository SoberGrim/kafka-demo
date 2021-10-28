package com.sobergrim.kafka.consumer;

import com.sobergrim.kafka.constants.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = KafkaConstants.TOPIC1, groupId = KafkaConstants.DEF_GROUP_ID)
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = KafkaConstants.TOPIC1)
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
    }
}
