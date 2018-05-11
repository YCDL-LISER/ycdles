package com.liser.websocket.client;

import com.liser.websocket.client.initializer.WebSocketClientChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.URI;
import java.util.Date;

public class NettyWSClient {

    public void connect(String host, int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true) // 禁用nagle算法*/
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new WebSocketClientChannelInitializer());

            final ChannelFuture future = bootstrap.connect(host, port).sync(); // 连接到远程节点
            future.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("连接websocket服务器成功");
                    }
                }
            });
            future.channel().writeAndFlush(new TextWebSocketFrame("服务时间：" + new Date()));
            future.channel().closeFuture().sync(); // 阻塞，直到 Channel 关闭

        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8090;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }

        URI uri = new URI("ws://127.0.0.1:8090/ycdl/websocket");
        NettyWSClient nettyWSClient = new NettyWSClient();
        nettyWSClient.connect(uri.getHost(), port);
    }
}
