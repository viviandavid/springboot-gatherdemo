package com.example.elastic.controller;

import com.example.elastic.service.elasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class elasticController {

    @Autowired
    private elasticService service;

    @RequestMapping(value = "/ttt",method = RequestMethod.GET)
    public boolean test() throws IOException {
        return service.IndexExists();
    }
}
