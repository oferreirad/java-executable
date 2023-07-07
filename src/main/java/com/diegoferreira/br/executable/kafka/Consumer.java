package com.diegoferreira.br.executable.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Properties;

public class Consumer {

    private static final String CLIEND_ID = "0";
    @Value("${boostrap.servers}")
    private static final String BOOTSTRAP_SERVERS = "SERVER";

    @Value("${security.protocol}")
    private static final String SECURITY_PROTOCOL = "SASL_SSL";

    @Value("${sasl.mechanism}")
    private static final String SASL_MECHANISM = "PLAIN";

    @Value("${sasl.user}")
    private static final String SASL_USER = "PASSWORD";

    @Value("${sasl.password}")
    private static final String SASL_PASSWORD = "USERNAME";
    private static final String ACKS = "all";

    private static final String TOPIC = "TOPIC";

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
        config.put("group.id", "sb-test-group");
        config.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("security.protocol", SECURITY_PROTOCOL);
        config.put("sasl.mechanism", SASL_MECHANISM);
        config.put("ssl.endpoint.identification.algorithm", "https");
        config.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + SASL_USER + "\" password=\"" + SASL_PASSWORD + "\";");
        return new KafkaConsumer(config);
    }

}
