package com.example.springbootmanualkafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Component
public class KakfaPropertiesConfig {

    @Bean
    public KafkaConsumer<String,String> kafkaConsumer() {
        Properties props = new Properties();
        //kafka服务器地址
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.63:9092,192.168.0.64:9092,192.168.0.65:9092");
        //必须指定消费者组
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "spider-ocr-recognition-group-offline");
//        props.put("session.timeout.ms", "30000");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//        props.put("heartbeat.interval.ms", 1000);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,2000);
        //设置数据key和value的序列化处理类
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("spider_offline_mark_file_queue"));
        return consumer;
    }
}
