package com.qiao.kafkastudy.helloworld;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CustomerProducer {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

//        createTopic(properties);
        send(properties);
    }

    public static void createTopic(Properties properties) {
        short replicationFactor = 1;
        Map<String, String> newTopicConfig = new HashMap<>();
        newTopicConfig.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_COMPACT);
        newTopicConfig.put(TopicConfig.COMPRESSION_TYPE_CONFIG, "lz4");
        NewTopic newTopic = new NewTopic("first", 1, replicationFactor).configs(newTopicConfig);
        Admin admin = Admin.create(properties);
        admin.createTopics(
                Collections.singleton(newTopic)
        );
        admin.close();
    }

    public static void send(Properties properties) {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        kafkaProducer.send(new ProducerRecord<>("second", "test11111"));
        System.out.println("sent ======================== ");
        kafkaProducer.close();
    }

}
