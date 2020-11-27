package com.example.springbootnettyclient.netty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LSD
 * @date 2020/11/26 19:30
 */
@Component
public class NettyParams {


    public static int port;

    public static String host;

    @Value("${netty.port}")
    public void setPort(int port) {
        this.port = port;
    }

    @Value("${netty.host}")
    public void setHost(String host) {
        this.host = host;
    }
}
