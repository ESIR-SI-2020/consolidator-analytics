package com.esir.jxc.mpc.kafka;

import com.esir.jxc.mpc.EventRouting;
import com.esir.jxc.mpc.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

@Service
@Log4j
public class ConsumerKafka {

    @Autowired
    EventRouting eventRouting;

    @KafkaListener(topics = "users", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload Event event) throws IOException {
        log.debug(String.format("Consumed message -> %s", event.getType()));
        eventRouting.processEvent(event);
    }
}