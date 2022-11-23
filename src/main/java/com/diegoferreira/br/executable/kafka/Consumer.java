package com.diegoferreira.br.executable.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Properties;

public class Consumer {

    private static final String CLIEND_ID = "0";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";
    private static final String ACKS = "all";

    private static final String TOPIC = "test.topic";

    private static final String KEY = "test";


    public static void main(String[] args) {
        KafkaConsumer<String, String> consumer = getConsumer();
        consumer.subscribe(Collections.singleton(TOPIC));
        ConsumerRecords<String, String> records = consumer.poll(Duration.of(10000000L, ChronoUnit.SECONDS));
        records.forEach(record -> System.out.println(record.value()));
    }

    public static KafkaConsumer getConsumer() {
        Properties config = new Properties();
        config.put("client.id", CLIEND_ID);
        config.put("group.id", "TEST_GROUP");
        config.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer(config);
    }

}
