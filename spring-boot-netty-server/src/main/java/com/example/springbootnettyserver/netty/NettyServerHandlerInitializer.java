package com.example.springbootnettyserver.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @author LSD
 * @date 2020/11/26 10:50
 */
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                //空闲检测
                .addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                .addLast(new ServerIdleStateHandler())
                .addLast(new NettyServerHandler());
    }
}
