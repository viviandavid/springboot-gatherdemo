package com.example.springbootnacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("na")
//@RefreshScope
public class MyNacosController {

    @GetMapping("/test")
    public String getNacInfo(){
        return "welcome to my world";
    }
}
