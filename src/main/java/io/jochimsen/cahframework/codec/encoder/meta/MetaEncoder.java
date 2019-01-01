package io.jochimsen.cahframework.codec.encoder.meta;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.protocol.object.meta.MetaObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public class MetaEncoder extends MessageToByteEncoder<MetaObject> {
    @Override
    protected void encode(final ChannelHandlerContext ctx, final MetaObject msg, final ByteBuf out) {
        out.writeInt(Version.PROTOCOL_VERSION);

        final int messageId = msg.getMessageId();
        out.writeInt(messageId);

        final ProtocolInputStream stream = msg.getStream();

        if(stream != null) {
            final byte[] rawMessage = stream.getBuffer();
            final int messageLength = rawMessage.length;

            out.writeInt(messageLength);
            out.writeBytes(rawMessage, 0, messageLength);
        } else {
            out.writeInt(0);
        }
    }
}
