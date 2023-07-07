package com.diegoferreira.br.executable.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;
import java.util.logging.Logger;

public class Producer {

    static Logger LOG = Logger.getLogger(Producer.class.getName());
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
        KafkaProducer<String, String> producer = getProducer();
        try {
            for (int i = 0; i < 10000; i++) {
                LOG.info("Producing " + i);
                producer.send(getRecord("test", TOPIC, KEY));
            }
        } catch (Exception e) {
            LOG.severe(String.format("Error while trying to send message. Error message: %s", e.getMessage()));
        }

    }

    public static ProducerRecord getRecord(String content, String topic, String key) {
        return new ProducerRecord(topic, 5, key, content);
    }

    public static KafkaProducer getProducer() {
        Properties config = new Properties();
        config.put("client.id", CLIEND_ID);
        config.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        config.put("acks", ACKS);
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("security.protocol", SECURITY_PROTOCOL);
        config.put("sasl.mechanism", SASL_MECHANISM);
        config.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + SASL_USER + "\" password=\"" + SASL_PASSWORD + "\";");
        config.put("enable.idempotence", "true");
        config.put("ssl.endpoint.identification.algorithm", "https");
        config.put("ssl.enabled.protocols", "TLSv1.2,TLSv1.3");
        config.put("retry.backoff.ms", "500");
        config.put("request.timeout.ms", "20000");
        return new KafkaProducer<String, String>(config);
    }
}
