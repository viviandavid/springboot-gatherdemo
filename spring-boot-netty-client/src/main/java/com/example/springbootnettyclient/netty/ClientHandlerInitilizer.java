package com.example.springbootnettyclient.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

public class ClientHandlerInitilizer extends ChannelInitializer<Channel> {

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;  //最大长度
    private static final int LENGTH_FIELD_LENGTH = 4;  //长度字段所占的字节数
    private static final int LENGTH_FIELD_OFFSET = 2;  //长度偏移
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
//                .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
//                .addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                .addLast(new MyProtocolDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_FIELD_LENGTH,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,false))
                .addLast(new MyProtocolEncoder())
                .addLast(new NettyClientHandler());
    }
}
