package io.jochimsen.cahframework.initializer;

import io.jochimsen.cahframework.handler.inbound.InboundMessageHandlerBase;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class SslProtocolMessageChannelInitializer extends ProtocolMessageChannelInitializer {
    private final SslContext sslCtx;
    private String host;
    private int port;

    public SslProtocolMessageChannelInitializer(final SslContext sslCtx, final InboundMessageHandlerBase inboundMessageHandlerBase) {
        super(inboundMessageHandlerBase);

        this.sslCtx = sslCtx;
    }

    public SslProtocolMessageChannelInitializer(final SslContext sslCtx, final InboundMessageHandlerBase inboundMessageHandlerBase, final String host, final int port) {
        super(inboundMessageHandlerBase);

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
