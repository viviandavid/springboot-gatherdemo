package com.example.springbootnettyclient.netty;

import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class MyProtocolEncoder extends MessageToByteEncoder<MyProtocolBean> {

    @Override
    protected void encode(ChannelHandlerContext ctx, MyProtocolBean msg, ByteBuf out) throws Exception {
        if(msg == null){
            throw new Exception("msg is null");
        }
        out.writeByte(msg.getType());
        out.writeByte(msg.getFlag());
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent().getBytes(Charset.forName("UTF-8")));
    }
}