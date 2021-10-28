package com.sobergrim.kafka;

import com.sobergrim.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Startup {
    private KafkaProducer producer;

    @Autowired
    public void setService(KafkaProducer producer) {
        this.producer = producer;
    }

    @Bean
    public void init() {
        System.out.println("Startup initializing");
        producer.sendMessage("Hello Kafka");
        producer.sendMessageWithFeedback("Hi!");
    }

}