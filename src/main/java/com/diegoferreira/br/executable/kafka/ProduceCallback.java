package com.diegoferreira.br.executable.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.logging.Logger;

public class ProduceCallback implements Callback {

    static Logger LOG = Logger.getLogger(Producer.class.getName());

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        LOG.info(String.format("The record was produced at %s to topic %s.", recordMetadata.timestamp(),
                recordMetadata.topic()));
    }
}
