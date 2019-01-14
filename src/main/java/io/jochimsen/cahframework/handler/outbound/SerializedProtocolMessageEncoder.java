package io.jochimsen.cahframework.handler.outbound;

import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.util.ProtocolOutputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import javafx.util.Pair;

public class SerializedProtocolMessageEncoder extends MessageToByteEncoder<Pair<Integer, ProtocolOutputStream>> {
    @Override
    protected void encode(final ChannelHandlerContext ctx, final Pair<Integer, ProtocolOutputStream> msg, final ByteBuf out) {
        out.writeInt(Version.PROTOCOL_VERSION);

        final int messageId = msg.getKey();
        out.writeInt(messageId);

        final ProtocolOutputStream protocolStream = msg.getValue();
        final byte[] buffer = protocolStream.getBuffer();
        final int messageLength = buffer.length;

        out.writeInt(messageLength);
        out.writeBytes(buffer, 0, messageLength);
    }
}
