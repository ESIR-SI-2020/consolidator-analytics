package com.esir.jxc.mpc;

import com.esir.jxc.mpc.model.Event;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerKafka {

    @Autowired EventRouting eventRouting;
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "esir2019")
    public void consume(Event event) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", event.getName()));
        eventRouting.processEvent(event);
    }
}