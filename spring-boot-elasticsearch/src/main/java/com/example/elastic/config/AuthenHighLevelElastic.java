package com.example.elastic.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenHighLevelElastic {

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String hostname;

    @Value("${spring.data.elasticsearch.cluster-port}")
    private int port;

    @Value("${spring.data.elasticsearch.username}")
    private String userName;

    @Value("${spring.data.elasticsearch.password}")
    private String password;

    @Bean
    public RestHighLevelClient client(){
        /*用户认证对象*/
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        /*设置账号密码*/
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(userName, password));
        /*创建rest client对象*/
        RestClientBuilder builder = RestClient.builder(new HttpHost(hostname,port))
                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                        return httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    }
                });
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }


}
