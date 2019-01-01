package io.jochimsen.cahframework.channel_handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.ssl.SslHandler;

public abstract class SslServerProcessingHandler extends ProcessingHandler {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().get(SslHandler.class).handshakeFuture();
    }
}
