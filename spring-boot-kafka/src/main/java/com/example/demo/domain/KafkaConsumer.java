package com.example.demo.domain;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topicPattern = "${spring.kafka.topics.file}")
    public void processNewsMessage(ConsumerRecord<String, String> record) {
        String msg = record.value();
//        System.out.println("msg");
        Map<String, Object> data = JSONUtil.toBean(msg, new cn.hutool.core.lang.TypeReference<HashMap<String, Object>>() {
        }, true);
        String spiderId = data.get("spiderId").toString();
        System.out.println(spiderId);
//        try {
//            Map<String, Object> data = JSONUtil.toBean(msg, new cn.hutool.core.lang.TypeReference<HashMap<String, Object>>() {
//            }, true);
//        } catch (Exception e) {
//            log.error("covert data error,topic:{}, offset:{}", record.topic(), record.offset(), e);
//        }
    }
}
