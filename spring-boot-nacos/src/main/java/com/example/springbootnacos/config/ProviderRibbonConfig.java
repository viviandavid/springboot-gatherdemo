//package com.example.springbootnacos.config;
//
//import com.netflix.loadbalancer.BestAvailableRule;
//import com.netflix.loadbalancer.IRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
////Ribbon更细力度的配置，可以针对不同服务设置Load Balance策略
//@Configuration
//public class ProviderRibbonConfig {
//
//    //BestAvailableRule策略用来选取最少并发量请求的服务器
//    @Bean
//    public IRule ribbonRule(){
//        return new BestAvailableRule();
//    }
//}
