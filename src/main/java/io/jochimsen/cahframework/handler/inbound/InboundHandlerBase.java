package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.exception.session.ProtocolMessageDeserializationException;
import io.jochimsen.cahframework.exception.session.SessionException;
import io.jochimsen.cahframework.handler.message.MessageHandler;
import io.jochimsen.cahframework.protocol.error.ErrorMessageException;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorMessage;
import io.jochimsen.cahframework.session.Session;
import io.jochimsen.cahframework.util.MessageHandlerFactory;
import io.jochimsen.cahframework.util.MessageMapper;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
@AllArgsConstructor
public abstract class InboundHandlerBase<S extends Session, M extends ProtocolMessage> extends ChannelInboundHandlerAdapter {

    @NonNull
    private final MessageMapper<M, S> messageMapper;
    private MessageHandlerFactory<M, S> messageHandlerFactory;

    @Override
    public final void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        final RawProtocolMessageInput rawProtocolMessageInput = (RawProtocolMessageInput) msg;

        final int messageId = rawProtocolMessageInput.getMessageId();
        final ProtocolInputStream protocolInputStream = rawProtocolMessageInput.getProtocolInputStream();
        final S session = getSession(ctx);

        try {
            if (messageId == MessageCode.ERROR) {
                final ErrorMessage errorMessage = protocolInputStream.readObject();
                onErrorReceived(errorMessage, session);
            } else {
                handleMessage(messageId, protocolInputStream, session);
            }
        } catch (final IOException e) {
            throw new ProtocolMessageDeserializationException(e);
        }
    }

    private void handleMessage(final int messageId, final ProtocolInputStream protocolInputStream, final S session) throws Exception {
        //ToDo: Add logging

        final MessageMapper.Pair<M, S> pair = messageMapper.map(messageId);

        if (pair == null) {
            onUnknownMessage(session, messageId);
            return;
        }

        if (pair.getMessageClass() == null) {
            throw new IllegalArgumentException("protocol message class cannot be null!");
        }

        final M message = protocolInputStream.readObject(pair.getMessageClass());

        onPostHandleMessage(session, message);

        final Class<? extends MessageHandler<? extends M, S>> messageHandlerClass = pair.getMessageHandlerClass();

        if(messageHandlerClass != null) {
            MessageHandler<M, S> messageHandler = null;

            if(messageHandlerFactory != null) {
                //noinspection unchecked
                messageHandler = (MessageHandler<M, S>)messageHandlerFactory.create(messageHandlerClass);

                if(messageHandler == null) {
                    throw new InstantiationException("could not create message handler via the provided message handler factory (returned null)!");
                }
            } else {
                //noinspection unchecked
                messageHandler = (MessageHandler<M, S>)messageHandlerClass.getConstructor().newInstance();
            }

            messageHandler.handleMessage(message, session);
        }

        onPostHandleMessage(session, message);
    }

    @Override
    public final void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
        final S session = getSession(ctx);

        if(cause instanceof ErrorMessageException) {
            onErrorMessageException(session, (ErrorMessageException) cause);
        } else if(cause instanceof SessionException) {
            onSessionException(session, (SessionException) cause);
        } else {
            onUncaughtException(session, cause);
        }

        session.close();
    }

    protected void onErrorMessageException(final S session, final ErrorMessageException cause) {
        final ErrorMessage errorMessage = new ErrorMessage(cause.getErrorCode(), cause.getMessage());
        session.say(errorMessage);
    }

    protected void onSessionException(final S session, final SessionException cause) {

    }

    protected abstract void onUncaughtException(final S session, final Throwable cause);

    @Override
    public final void handlerRemoved(final ChannelHandlerContext ctx) throws Exception {
        final S session = getSession(ctx);
        closeSession(session);

        super.handlerRemoved(ctx);
    }

    protected void closeSession(final S session) {
        session.onClose();
    }

    protected void onUnknownMessage(final S session, final int messageId) {
        closeSession(session);
    }

    protected void onPreHandleMessage(final S session, final M message) {

    }

    protected void onPostHandleMessage(final S session, final M message) {

    }

    protected abstract S getSession(final ChannelHandlerContext ctx);

    protected abstract void onErrorReceived(final ErrorMessage errorMessage, final S session);
}