package com.example.springbootnettyserver.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @author LSD
 * @date 2020/11/26 10:50
 */
public class NettyServerHandlerInitializer extends ChannelInitializer<Channel> {

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;  //最大长度
    private static final int LENGTH_FIELD_LENGTH = 4;  //长度字段所占的字节数
    private static final int LENGTH_FIELD_OFFSET = 2;  //长度偏移
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                //空闲检测
//                .addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
//                .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                .addLast(new MyProtocolDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_FIELD_LENGTH,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,false))
                .addLast(new MyProtocolEncoder())
                .addLast(new ServerIdleStateHandler())
                .addLast(new NettyServerHandler());
    }
}
