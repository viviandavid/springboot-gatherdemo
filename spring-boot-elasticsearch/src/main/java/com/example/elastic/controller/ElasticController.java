package com.example.elastic.controller;

import com.example.elastic.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ElasticController {

    @Autowired
    private ElasticService service;

    @RequestMapping(value = "/ttt",method = RequestMethod.GET)
    public boolean test() throws IOException {
        return service.IndexExists();
    }
}
