package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.ssl.SslHandler;

public abstract class SslHandshakeInboundHandlerBase extends InboundHandlerBase {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        ctx.pipeline().get(SslHandler.class).handshakeFuture().addListener(future -> onSuccessfulHandshake(getSession(ctx)));
    }

    protected abstract void onSuccessfulHandshake(final Session session);
}
