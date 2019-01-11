package io.jochimsen.cahframework.handler.outbound;

import io.jochimsen.cahframework.handler.SerializedProtocolMessage;
import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.util.ProtocolStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SerializedProtocolMessageEncoder extends MessageToByteEncoder<SerializedProtocolMessage> {
    @Override
    protected void encode(final ChannelHandlerContext ctx, final SerializedProtocolMessage msg, final ByteBuf out) {
        out.writeInt(Version.PROTOCOL_VERSION);

        final int messageId = msg.getMessageId();
        out.writeInt(messageId);

        final ProtocolStream protocolStream = msg.getProtocolStream();

        if(protocolStream != null) {
            final byte[] buffer = protocolStream.getBuffer();
            final int messageLength = buffer.length;

            out.writeInt(messageLength);
            out.writeBytes(buffer, 0, messageLength);
        } else {
            out.writeInt(0);
        }
    }
}
