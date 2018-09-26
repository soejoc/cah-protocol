package codec.encoder.meta;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import protocol.object.meta.MetaObject;
import util.ProtocolInputStream;

public class MetaEncoder extends MessageToByteEncoder<MetaObject> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MetaObject msg, ByteBuf out) {
        final int messageId = msg.getMessageId();
        final ProtocolInputStream stream = msg.getStream();
        final byte[] rawMessage = stream.getBuffer();
        final int messageLength = rawMessage.length;

        out.writeInt(messageId);
        out.writeInt(messageLength);
        out.writeBytes(rawMessage, 0, messageLength);
    }
}
