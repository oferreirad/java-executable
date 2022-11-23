package com.diegoferreira.br.executable.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    private static final String CLIEND_ID = "0";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";
    private static final String ACKS = "all";

    private static final String TOPIC = "test.topic";

    private static final String KEY = "test";


    public static void main(String[] args) {
        KafkaProducer<String, String> producer = getProducer();
        for (int i = 0; i < 1000000000; i++) {
            System.out.println("Producing " + i);
            producer.send(getRecord("test", TOPIC, KEY));
        }
    }

    public static ProducerRecord getRecord(String content, String topic, String key) {
        return new ProducerRecord(topic, key, content);
    }

    public static KafkaProducer getProducer() {
        Properties config = new Properties();
        config.put("client.id", CLIEND_ID);
        config.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        config.put("acks", ACKS);
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>(config);
    }
}
