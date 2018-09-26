package codec.decoder.meta;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import protocol.object.meta.MetaObject;
import util.ProtocolInputStream;

import java.util.List;

public class MetaDecoder extends ReplayingDecoder<MetaObject> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        final int messageId = in.readInt();
        final int messageLength = in.readInt();
        final byte[] message = new byte[messageLength];

        in.readBytes(message, 0, messageLength);

        final ProtocolInputStream stream = new ProtocolInputStream(message);

        MetaObject metaObject = new MetaObject(messageId, stream);
        out.add(metaObject);
    }
}
