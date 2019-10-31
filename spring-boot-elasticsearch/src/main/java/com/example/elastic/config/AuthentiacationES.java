//package com.example.elastic.config;
//
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.SecureString;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
//import org.elasticsearch.xpack.core.security.authc.support.UsernamePasswordToken;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Collections;
//
//@Configuration
//public class AuthentiacationES {
//
//    @Bean
//    public TransportClient transportClient() throws UnknownHostException {
//        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
//                .put("cluster.name", "my-application")
//                .put("xpack.security.user","elastic:654321")
//                .build())
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("10.20.4.66"), 9300));
//
//        String token = UsernamePasswordToken.basicAuthHeaderValue("elastic",new SecureString("654321".toCharArray()));
//        client.filterWithHeader(Collections.singletonMap("Authorization",token)).prepareSearch().get();
//        return client;
//
////                        .put("xpack.security.user","elastic:654321")
//
////        Settings settings = Settings.builder()
////                .put("cluster.name", "my-application").build();
////        TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("10.20.4.66"),9300);
////        TransportClient transportClient = new PreBuiltTransportClient(settings)
////                .addTransportAddress(transportAddress);
////        return transportClient;
//
//    }
//
////    @Bean
////    public ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
////        return new ElasticsearchTemplate(transportClient());
////    }
//}
