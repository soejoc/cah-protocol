package io.jochimsen.cahframework.codec.decoder.meta;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.Version;
import io.jochimsen.cahframework.protocol.object.meta.MetaObject;
import io.jochimsen.cahframework.protocol.error.exception.InvalidProtocolVersionException;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class MetaDecoder extends ReplayingDecoder<MetaObject> {
    @Override
    protected void decode(final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> out) {
        final int version = in.readInt();
        final int messageId = in.readInt();

        if(version != Version.PROTOCOL_VERSION && messageId != MessageCode.ERROR) {
            throw new InvalidProtocolVersionException(version, Version.PROTOCOL_VERSION);
        }

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
