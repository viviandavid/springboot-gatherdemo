package com.example.springbootnettyclient.netty;

import com.example.springbootnettyserver.pojo.HeartBeatInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author pjmike
 * @create 2018-10-25 17:15
 */
@Component
@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private  NettyClient nettyClient = new NettyClient();

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        /**
         * 这一部分是当客户端定时心跳的时候才用到，我这个demo用的是服务端心跳。所以这里就没有用处了。
         * 想用的话，配合IdleStateHandler方法哦
         */
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state().equals(IdleState.READER_IDLE)) {
                System.out.println("长期没收到服务器推送数据");
                //可以选择重新连接
            } else if (event.state().equals(IdleState.WRITER_IDLE)) {
                System.out.println("长期未向服务器发送数据");
                //发送心跳包
                HeartBeatInfo heartBeatInfo = new HeartBeatInfo();
                heartBeatInfo.setStatus(0);
                heartBeatInfo.setName("客户端采集器");
                ctx.writeAndFlush(heartBeatInfo);
            } else if (event.state().equals(IdleState.ALL_IDLE)) {
                System.out.println("ALL");
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HeartBeatInfo){
            System.out.print("收到服务端修改后的消息："+((HeartBeatInfo) msg).getName());
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //如果运行过程中服务端挂了,执行重连机制
        System.out.println("服务器挂了......");
        EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> nettyClient.start(), 2, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("捕获的异常：{}",cause.getMessage());
//        ctx.channel().close();
    }
}
