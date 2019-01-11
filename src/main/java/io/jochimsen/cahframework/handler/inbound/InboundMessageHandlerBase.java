package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.handler.SerializedProtocolMessage;
import io.jochimsen.cahframework.protocol.error.ErrorBase;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorMessage;
import io.jochimsen.cahframework.session.Session;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class InboundMessageHandlerBase extends ChannelInboundHandlerAdapter {

    @Override
    public final void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        final SerializedProtocolMessage serializedProtocolMessage = (SerializedProtocolMessage) msg;

        final int messageId = serializedProtocolMessage.getMessageId();
        final ProtocolInputStream protocolInputStream = (ProtocolInputStream)serializedProtocolMessage.getProtocolStream();
        final Session session = getSession(ctx);

        if(messageId == MessageCode.ERROR) {
            final ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.deserialize(protocolInputStream);

            onErrorReceived(errorMessage, session);
        } else {
            handleMessage(messageId, protocolInputStream, session);
        }
    }

    @Override
    public final void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
        final Session session = getSession(ctx);

        if(cause instanceof ErrorBase) {
            final ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.errorCode = ((ErrorBase) cause).getErrorCode();
            errorMessage.message = cause.getMessage();

            session.say(errorMessage);
            session.close();
        } else {
            super.exceptionCaught(ctx, cause);
        }
    }

    @Override
    public final void handlerRemoved(final ChannelHandlerContext ctx) throws Exception {
        final Session session = getSession(ctx);
        closeSession(session);

        super.handlerRemoved(ctx);
    }

    protected void closeSession(final Session session) {
        session.onClose();
    }

    protected abstract Session getSession(final ChannelHandlerContext ctx);

    protected abstract void handleMessage(final int messageId, final ProtocolInputStream protocolInputStream, final Session session);

    protected abstract void onErrorReceived(final ErrorMessage errorMessage, final Session session);
}