package com.liser.websocket.client.initializer;

import com.liser.websocket.client.handler.WebSocketClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    private WebSocketClientHandshaker handshaker;

    public WebSocketClientChannelInitializer() throws URISyntaxException {
        URI uri = new URI("ws://127.0.0.1:8090/ycdl/websocket");
        HttpHeaders httpHeaders = new DefaultHttpHeaders();
        handshaker = WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, true, httpHeaders);

    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new HttpClientCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new WebSocketClientProtocolHandler(handshaker));
        pipeline.addLast(new WebSocketClientHandler());

    }
}
