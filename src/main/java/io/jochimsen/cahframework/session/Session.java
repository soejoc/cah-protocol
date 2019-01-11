package io.jochimsen.cahframework.session;

import io.jochimsen.cahframework.exception.FlushException;
import io.jochimsen.cahframework.exception.InactiveChannelContextException;
import io.jochimsen.cahframework.handler.SerializedProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.util.ProtocolOutputStream;
import io.netty.channel.ChannelHandlerContext;

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

        final int messageId = protocolMessage.getMessageId();
        ProtocolOutputStream protocolOutputStream = null;

        if(protocolMessage.hasCodec()) {
            protocolOutputStream = new ProtocolOutputStream();
            protocolMessage.serialize(protocolOutputStream);

            try {
                protocolOutputStream.flush();
            } catch (final IOException e) {
                throw new FlushException("Could not flush protocol output stream", e);
            }
        }

        final SerializedProtocolMessage serializedProtocolMessage = new SerializedProtocolMessage(messageId, protocolOutputStream);
        channelHandlerContext.writeAndFlush(serializedProtocolMessage);
    }

    public void onClose() {
        channelHandlerContext = null;
    }

    public boolean isActive() {
        return channelHandlerContext != null;
    }
}
