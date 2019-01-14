package io.jochimsen.cahframework.session;

import io.jochimsen.cahframework.exception.internal.ProtocolMessageSerializationException;
import io.jochimsen.cahframework.exception.session.InactiveChannelContextException;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.util.ProtocolOutputStream;
import io.netty.channel.ChannelHandlerContext;
import javafx.util.Pair;

import java.io.IOException;

public abstract class Session {
    protected ChannelHandlerContext channelHandlerContext;

    public Session(final ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(final ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public void close() {
        channelHandlerContext.close();
    }

    public void say(final ProtocolMessage protocolMessage) {
        if(!isActive()) {
            throw new InactiveChannelContextException();
        }

        try {
            final int messageId = protocolMessage.getMessageId();
            final ProtocolOutputStream protocolOutputStream = new ProtocolOutputStream();
            protocolOutputStream.write(protocolMessage);
            protocolOutputStream.flush();

            channelHandlerContext.writeAndFlush(new Pair<>(messageId, protocolOutputStream));
        } catch (final IOException e) {
            throw new ProtocolMessageSerializationException(e);
        }
    }

    public void onClose() {
        channelHandlerContext = null;
    }

    public boolean isActive() {
        return channelHandlerContext != null && !channelHandlerContext.isRemoved();
    }
}
