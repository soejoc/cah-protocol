package io.jochimsen.cahframework.session;

import io.jochimsen.cahframework.exception.internal.ProtocolMessageSerializationException;
import io.jochimsen.cahframework.exception.session.InactiveChannelContextException;
import io.jochimsen.cahframework.handler.outbound.RawProtocolMessageOutput;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorMessage;
import io.jochimsen.cahframework.util.ProtocolOutputStream;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public abstract class Session<M extends ProtocolMessage> {

    @Getter
    @Setter
    protected ChannelHandlerContext channelHandlerContext;

    public void close() {
        channelHandlerContext.close();
    }

    private void sayActual(final ProtocolMessage protocolMessage) {
        if(protocolMessage == null) {
            throw new NullPointerException("protocolMessage is null!");
        }

        if(!isActive()) {
            throw new InactiveChannelContextException();
        }

        try {
            final int messageId = protocolMessage.getMessageId();
            final ProtocolOutputStream protocolOutputStream = new ProtocolOutputStream();
            protocolOutputStream.write(protocolMessage);
            protocolOutputStream.flush();

            channelHandlerContext.writeAndFlush(new RawProtocolMessageOutput(messageId, protocolOutputStream));
        } catch (final IOException e) {
            throw new ProtocolMessageSerializationException(e);
        }
    }

    public void say(final M message) {
        sayActual(message);
    }

    public void say(final ErrorMessage errorMessage) {
        sayActual(errorMessage);
    }

    public void onClose() {
        channelHandlerContext = null;
    }

    public boolean isActive() {
        return channelHandlerContext != null && !channelHandlerContext.isRemoved();
    }
}
