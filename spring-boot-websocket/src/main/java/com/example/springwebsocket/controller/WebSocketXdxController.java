package com.example.springwebsocket.controller;

import com.example.springwebsocket.service.WebSocketXdxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketXdxController {

    @Autowired
    private WebSocketXdxService webSocketXdxService;
    /**
     *
     * @param shipId
     * @return
     */
    @GetMapping("/xdx/text")
    public Object xdxTest(String shipId) throws InterruptedException {
        return webSocketXdxService.xdxTest(shipId);
    }

}
