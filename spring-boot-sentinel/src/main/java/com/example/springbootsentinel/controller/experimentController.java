package com.example.springbootsentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsd
 * @Date 2020/4/17 15:27
 * @Version 1.0
 **/
@RestController
public class experimentController {

    /**
     * 限流降级
     * @return
     */
    @SentinelResource(value = "testInterface", blockHandler = "sayHelloExceptionHandler")
    @GetMapping("/test")
    public String test(){
        return "sentinelTest";
    }

    /**
     * 熔断降级
     * @return
     */
    @SentinelResource(value = "circuitBreaker", fallback = "circuitBreakerFallback", blockHandler = "sayHelloExceptionHandler")
    public String circuitBreaker(String name){
        if ("zhangsan".equals(name)){
            return "hello,"+ name;
        }
        throw new RuntimeException("发生异常");
    }

    public String circuitBreakerFallback(){
        return "服务异常，熔断降级, 请稍后重试!";
    }

    public String sayHelloExceptionHandler(BlockException ex){
        return "访问过快，限流降级, 请稍后重试!";
    }
}
