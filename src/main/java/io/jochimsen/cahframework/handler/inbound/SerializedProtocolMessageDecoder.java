package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.handler.SerializedProtocolMessage;
import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.protocol.error.error_message.InvalidProtocolVersionException;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class SerializedProtocolMessageDecoder extends ReplayingDecoder<SerializedProtocolMessage> {
    @Override
    protected void decode(final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> out) {
        final int version = in.readInt();
        final int messageId = in.readInt();

        if(version != Version.PROTOCOL_VERSION && messageId != MessageCode.ERROR) {
            throw new InvalidProtocolVersionException(version, Version.PROTOCOL_VERSION);
        }

        final int messageLength = in.readInt();
        ProtocolInputStream protocolInputStream = null;

        if(messageLength > 0) {
            final byte[] message = new byte[messageLength];
            in.readBytes(message, 0, messageLength);

            protocolInputStream = new ProtocolInputStream(message);
        }

        final SerializedProtocolMessage serializedProtocolMessage = new SerializedProtocolMessage(messageId, protocolInputStream);
        out.add(serializedProtocolMessage);
    }
}
