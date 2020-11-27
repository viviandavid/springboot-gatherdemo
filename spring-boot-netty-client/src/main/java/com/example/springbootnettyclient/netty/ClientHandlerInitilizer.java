package com.example.springbootnettyclient.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                .addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                .addLast(new NettyClientHandler());
    }
}
