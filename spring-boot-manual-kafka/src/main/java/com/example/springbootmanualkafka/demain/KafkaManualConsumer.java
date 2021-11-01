package com.example.springbootmanualkafka.demain;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@Slf4j
public class KafkaManualConsumer {

    @Resource
    private KafkaConsumer<String, String> kafkaConsumer;

    Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>(2);

    @PostConstruct
    public void test() {
        new Thread(() -> {
            try {
                for (;;) {
                    ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord<String, String> record : consumerRecords) {
//                        log.info("partition=%s, offset=%d, customer=%s",
//                                record.partition(), record.offset(), record.key());
                        System.out.println("partition:"+record.partition()+" offset： "+record.offset());
                        System.out.println(record.value());
//                        Map<String, String> data = JSONUtil.toBean(record.value(), new TypeReference<HashMap<String, String>>() {
//                        }, true);
                        // 记录分区的offset
                        currentOffsets.put(new TopicPartition(record.topic(),record.partition()),
                                new OffsetAndMetadata(record.offset()+1,"no metadata"));
                        kafkaConsumer.commitAsync(currentOffsets, new OffsetCommitCallback() {
                            @Override
                            public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                                if (e != null) {
                                    log.error("Commit failed for offsets", e);
                                }
                            }
                        });

                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }finally {
                // 同步提交来保证位移提交成功
                kafkaConsumer.commitSync();
                kafkaConsumer.close();
            }
        }).start();
    }
}
