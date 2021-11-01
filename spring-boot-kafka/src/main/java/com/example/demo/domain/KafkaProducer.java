package com.example.demo.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送消息到kafka
     */
    public void sendMessage(String topic, String message) {
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(topic,message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error(topic+"生产者发送消息失败："+ throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info(topic+"生产者发送消息成功："+ stringStringSendResult.toString());
            }
        });
//        RecordMetadata recordMetadata = null;
//        try {
//            recordMetadata = future.get().getRecordMetadata();
//        } catch (InterruptedException|ExecutionException e) {
//            log.error("kakfa返回消息错误："+e);
//        }
//        log.info("kafka信息："+"partition:"+recordMetadata.partition()+"offset:"+recordMetadata.offset());
    }
}