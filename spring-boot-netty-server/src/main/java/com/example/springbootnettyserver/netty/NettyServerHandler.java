package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.HeartBeatInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @author LSD
 * @date 2020/11/26 11:40
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress inteSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        System.out.println("已有客户端连接,端口为："+inteSocket.getPort());
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HeartBeatInfo){
            System.out.print("收到客户端消息：");
            System.out.println(((HeartBeatInfo) msg).getName());
            ((HeartBeatInfo) msg).setName("服务端名称");
            ctx.channel().writeAndFlush(msg);
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将消息发送队列中的消息写入到SocketChannel中发送给对方
        ctx.flush();
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //当发生异常时释放资源
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress inteSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        System.out.println("已有客户端断开连接,端口为："+inteSocket.getPort());
        super.channelInactive(ctx);
    }
}
