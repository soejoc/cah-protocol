package io.jochimsen.cahframework.initializer;

import io.jochimsen.cahframework.handler.inbound.InboundHandlerBase;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class SslProtocolMessageChannelInitializer extends ProtocolMessageChannelInitializer {
    private final SslContext sslCtx;
    private String host;
    private int port;

    public SslProtocolMessageChannelInitializer(final SslContext sslCtx, final InboundHandlerBase inboundHandlerBase) {
        super(inboundHandlerBase);

        this.sslCtx = sslCtx;
    }

    public SslProtocolMessageChannelInitializer(final SslContext sslCtx, final InboundHandlerBase inboundHandlerBase, final String host, final int port) {
        super(inboundHandlerBase);

        this.sslCtx = sslCtx;
        this.host = host;
        this.port = port;
    }

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        if(host != null && port != 0) {
            channelPipeline.addLast(sslCtx.newHandler(ch.alloc(), host, port));
        } else {
            channelPipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }

        super.initChannel(ch);
    }
}
