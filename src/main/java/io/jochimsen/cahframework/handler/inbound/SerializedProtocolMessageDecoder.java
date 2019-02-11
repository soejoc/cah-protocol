package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.exception.session.ProtocolMessageDeserializationException;
import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.protocol.error.error_message.InvalidProtocolVersionException;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.io.IOException;
import java.util.List;

public class SerializedProtocolMessageDecoder extends ReplayingDecoder<RawProtocolMessageInput> {
    @Override
    protected void decode(final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> out) {
        final int version = in.readInt();
        final int messageId = in.readInt();

        if(version != Version.PROTOCOL_VERSION && messageId != MessageCode.ERROR) {
            throw new InvalidProtocolVersionException(version, Version.PROTOCOL_VERSION);
        }

        final int messageLength = in.readInt();
        final byte[] message = new byte[messageLength];
        in.readBytes(message, 0, messageLength);

        try {
            final ProtocolInputStream protocolInputStream = new ProtocolInputStream(message);
            out.add(new RawProtocolMessageInput(messageId, protocolInputStream));
        } catch (final IOException e) {
            throw new ProtocolMessageDeserializationException(e);
        }
    }
}
