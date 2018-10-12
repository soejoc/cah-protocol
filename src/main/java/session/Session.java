package session;

import io.netty.channel.ChannelHandlerContext;
import protocol.object.ProtocolObject;
import protocol.object.meta.MetaObject;
import util.ProtocolInputStream;

public abstract class Session {
    protected final ChannelHandlerContext channelHandlerContext;

    public Session(final ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public void close() {
        channelHandlerContext.close();
    }

    public void say(final ProtocolObject protocolObject) {
        final int messageId = protocolObject.getMessageId();
        final byte[] rawObject = protocolObject.toRawObject();

        final ProtocolInputStream stream = (rawObject != null) ? new ProtocolInputStream(rawObject) : null;
        final MetaObject metaObject = new MetaObject(messageId, stream);

        channelHandlerContext.writeAndFlush(metaObject);
    }
}
