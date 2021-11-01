//package com.example.springbootmanualkafka.demain;
//
//import org.springframework.kafka.annotation.PartitionOffset;
//import org.springframework.kafka.annotation.TopicPartition;
//
//import java.lang.annotation.Annotation;
//
//public class TopicManualPartition implements TopicPartition {
//
//    String topic;
//
//    String[] partitions;
//
//    public TopicManualPartition(String topic, int partition) {
//        this.topic = topic;
//        this.partitions[0] = String.valueOf(partition);
//    }
//
//    @Override
//    public String topic() {
//        return topic;
//    }
//
//    @Override
//    public String[] partitions() {
//        return partitions;
//    }
//
//    @Override
//    public PartitionOffset[] partitionOffsets() {
//        return new PartitionOffset[0];
//    }
//
//    @Override
//    public Class<? extends Annotation> annotationType() {
//        return null;
//    }
//}
