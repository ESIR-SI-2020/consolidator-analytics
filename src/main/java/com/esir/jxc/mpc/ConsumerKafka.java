package com.esir.jxc.mpc;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.MockConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

public class ConsumerKafka {
    public static String TOPIC = "user";

    public void read() {
        TopicPartition topic = new TopicPartition(TOPIC, 0);

        MockConsumer<Long, String> consumer = new MockConsumer<Long, String>(OffsetResetStrategy.EARLIEST);
        consumer.assign(Collections.singletonList(topic));

        HashMap<TopicPartition, Long> beginningOffsets = new HashMap<>();
        beginningOffsets.put(topic, 0L);
        consumer.updateBeginningOffsets(beginningOffsets);

//        consumer.addRecord(new ConsumerRecord<>(TOPIC, 0, 0, 4141L, "test"));
        while(true) {
            ConsumerRecords<Long, String> records = consumer.poll(Duration.ofMillis(1000L));
            System.out.println("count: " + records.count());
            records.forEach(record -> System.out.println(record.value()));
        }

    }
}
