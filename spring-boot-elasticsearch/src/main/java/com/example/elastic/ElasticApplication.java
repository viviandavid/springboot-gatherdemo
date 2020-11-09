package com.example.elastic;

import com.example.elastic.service.ElasticService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ElasticApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ElasticApplication.class, args);
        ElasticService service = (ElasticService) context.getBean("elasticService");
        Thread thread = new Thread(service);
        thread.start();
    }

}
