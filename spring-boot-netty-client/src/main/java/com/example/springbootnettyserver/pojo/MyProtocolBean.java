package com.example.springbootnettyserver.pojo;

import lombok.Data;

@Data
public class MyProtocolBean {
    //类型  系统编号 0xA 表示A系统，0xB 表示B系统
    private byte type;
    //信息标志  0xA 表示心跳包    0xC 表示超时包  0xC 业务信息包
    private byte flag;
    //内容长度
    private int length;
    //内容
    private String content;

    public MyProtocolBean(byte flag, byte type, int length, String content) {
        this.flag = flag;
        this.type = type;
        this.length = length;
        this.content = content;
    }

}