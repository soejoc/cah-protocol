package codec.decoder.meta;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import protocol.Version;
import protocol.object.meta.MetaObject;
import protocol.error.exception.InvalidProtocolVersionException;
import util.ProtocolInputStream;

import java.util.List;

public class MetaDecoder extends ReplayingDecoder<MetaObject> {
    @Override
    protected void decode(final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> out) {
        final int version = in.readInt();

        if(version != Version.PROTOCOL_VERSION) {
            throw new InvalidProtocolVersionException(version, Version.PROTOCOL_VERSION);
        }

        final int messageId = in.readInt();
        final int messageLength = in.readInt();
        ProtocolInputStream stream = null;

        if(messageLength > 0) {
            final byte[] message = new byte[messageLength];
            in.readBytes(message, 0, messageLength);

            stream = new ProtocolInputStream(message);
        }

        final MetaObject metaObject = new MetaObject(messageId, stream);
        out.add(metaObject);
    }
}
