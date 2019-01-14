package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.exception.session.ProtocolMessageDeserializationException;
import io.jochimsen.cahframework.exception.session.SessionException;
import io.jochimsen.cahframework.protocol.error.ErrorMessageException;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorMessage;
import io.jochimsen.cahframework.session.Session;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import javafx.util.Pair;

import java.io.IOException;

public abstract class InboundMessageHandlerBase extends ChannelInboundHandlerAdapter {

    @Override
    public final void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        final Pair<Integer, ProtocolInputStream> messagePair = (Pair<Integer, ProtocolInputStream>) msg;

        final int messageId = messagePair.getKey();
        final ProtocolInputStream protocolInputStream = messagePair.getValue();
        final Session session = getSession(ctx);

        try {
            if (messageId == MessageCode.ERROR) {
                final ErrorMessage errorMessage = protocolInputStream.readObject(ErrorMessage.class);
                onErrorReceived(errorMessage, session);
            } else {
                handleMessage(messageId, protocolInputStream, session);
            }
        } catch (final IOException e) {
            throw new ProtocolMessageDeserializationException(e);
        }
    }

    @Override
    public final void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
        final Session session = getSession(ctx);

        if(cause instanceof ErrorMessageException) {
            onErrorMessageException(session, (ErrorMessageException) cause);
        } else if(cause instanceof SessionException) {
            onSessionException(session, (SessionException) cause);
        } else {
            onUncaughtException(session, cause);
        }

        session.close();
    }

    protected void onErrorMessageException(final Session session, final ErrorMessageException cause) {
        final ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.errorCode = cause.getErrorCode();
        errorMessage.message = cause.getMessage();

        session.say(errorMessage);
    }

    protected void onSessionException(final Session session, final SessionException cause) {

    }

    protected abstract void onUncaughtException(final Session session, final Throwable cause);

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

    protected abstract void handleMessage(final int messageId, final ProtocolInputStream protocolInputStream, final Session session) throws Exception;

    protected abstract void onErrorReceived(final ErrorMessage errorMessage, final Session session);
}