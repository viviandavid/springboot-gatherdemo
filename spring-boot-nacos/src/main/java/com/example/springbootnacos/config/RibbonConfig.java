//package com.example.springbootnacos.config;
//
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//
//
//@Configuration
////RibbonClients可以配置多个服务策略
//@RibbonClients({
//        //Ribbon更细力度的配置，可以针对不同服务设置Load Balance策略
//        @RibbonClient(name = "nacos-provider-service", configuration = ProviderRibbonConfig.class)
//})
//public class RibbonConfig {
//
//    //使用RestTemplate进行rest操作的时候，会自动使用负载均衡策略，它内部会在RestTemplate中加入LoadBalancerInterceptor这个拦截器，这个拦截器的作用就是使用负载均衡。
//    //默认情况下会采用轮询策
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//}
