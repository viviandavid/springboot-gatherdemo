package com.example.springbootnacosserver.controller;

import com.example.springbootnacosserver.feign.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("na")
@RefreshScope
public class MyNacosController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private MyClient myClient;

    @GetMapping("/server")
    public String getNacInfo(){
        return "this is a server ";
    }

    @GetMapping("/echo")
    public String getClientInfo() {
//        ServiceInstance serviceInstance = client.choose("my_nacos_client");
//        String url = serviceInstance.getUri() + "/na/test";
//        System.out.println("真实路由地址"+url);
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject(url, String.class);

        String result = myClient.getClient();
        return result;
    }
}
