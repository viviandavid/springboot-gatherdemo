package com.example.springwebsocket.service;

import com.example.springwebsocket.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WebSocketXdxService {


    @Autowired
    private WebSocket webSocket;


    public Object xdxTest(String shipId) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread.sleep(1000);
            webSocket.sendTextMessage(shipId, "thread"+i);
        }
        return null;
    }
}
