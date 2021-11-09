package com.example.springbootnettyserver.netty;

import com.example.springbootnettyserver.pojo.HeartBeatInfo;
import com.example.springbootnettyserver.pojo.MyProtocolBean;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Member;
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
        InetSocketAddress interSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        System.out.println("已有客户端连接,端口为："+interSocket.getPort());
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

//        System.out.println(msg.toString());
//        if (msg instanceof HeartBeatInfo){
//            System.out.print("收到客户端消息：");
//            System.out.println(((HeartBeatInfo) msg).getName());
//            ((HeartBeatInfo) msg).setName("服务端名称");
//            ctx.channel().writeAndFlush(msg);说
//        }
        if (msg instanceof MyProtocolBean){
            System.out.println(((MyProtocolBean)msg).getContent());
//            String message = "是服务端的消息";
//            ctx.writeAndFlush(new MyProtocolBean((byte)0xA, (byte)0xC, message.getBytes().length, message));

            StringBuffer sb = new StringBuffer();
            for(int i=0;i<10000;i++){
                sb.append(i)
                        .append("服务端数据");
            }
            String message = sb.toString();
            MyProtocolBean myProtocolBean = new MyProtocolBean((byte)0xA,(byte)0xC, message.getBytes().length, message);
            ctx.writeAndFlush(myProtocolBean);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将消息发送队列中的消息写入到SocketChannel中发送给对方
        ctx.flush();
    }


    @Override
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
