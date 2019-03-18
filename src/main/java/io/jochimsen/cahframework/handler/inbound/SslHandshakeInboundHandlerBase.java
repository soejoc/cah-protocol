package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.session.Session;
import io.jochimsen.cahframework.util.MessageMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.ssl.SslHandler;

public abstract class SslHandshakeInboundHandlerBase<S extends Session, M extends ProtocolMessage> extends InboundHandlerBase<S, M> {

    public SslHandshakeInboundHandlerBase(final MessageMapper<M, S> messageMapper) {
        super(messageMapper);
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        ctx.pipeline().get(SslHandler.class).handshakeFuture().addListener(future -> onSuccessfulHandshake(getSession(ctx)));
    }

    protected abstract void onSuccessfulHandshake(final S session);
}
