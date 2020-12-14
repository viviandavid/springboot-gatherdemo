package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.HeartBeatInfo;
import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 空闲检测
 *
 * @author pjmike
 * @create 2018-10-25 16:21
 */
@Slf4j
public class ServerIdleStateHandler extends IdleStateHandler {
    /**
     * 设置空闲检测时间为 30s
     */
    private static final int READER_IDLE_TIME = 10;
    public ServerIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        log.info("{} 秒内没有读取到数据,发送心跳包", READER_IDLE_TIME);
        String message = "come on baby!!!";
        ctx.writeAndFlush(new MyProtocolBean((byte)0xA,(byte)0xA,message.getBytes().length, message));
    }
}
