package com.example.springbootnacosserver.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "my-nacos-client")
public interface MyClient {

    @GetMapping(value = "/na/test")
    public String getClient();
}
