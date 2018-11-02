package session;

import io.netty.channel.ChannelHandlerContext;
import protocol.object.message.ProtocolMessage;
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

    public void say(final ProtocolMessage message) {
        final int messageId = message.getMessageId();
        final byte[] rawObject = message.toRawObject();

        final ProtocolInputStream stream = (rawObject != null) ? new ProtocolInputStream(rawObject) : null;
        final MetaObject metaObject = new MetaObject(messageId, stream);

        channelHandlerContext.writeAndFlush(metaObject);
    }
}
