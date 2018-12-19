package session;

import io.netty.channel.ChannelHandlerContext;
import protocol.object.message.ProtocolMessage;
import protocol.object.meta.MetaObject;
import throwable.exception.InactiveChannelContextException;
import util.ProtocolInputStream;

public abstract class Session {
    protected ChannelHandlerContext channelHandlerContext;

    public Session(final ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public void close() {
        channelHandlerContext.close();
    }

    public void say(final ProtocolMessage message) {
        if(!isActive()) {
            throw new InactiveChannelContextException();
        }

        final int messageId = message.getMessageId();
        final byte[] rawObject = message.toRawObject();

        final ProtocolInputStream stream = (rawObject != null) ? new ProtocolInputStream(rawObject) : null;
        final MetaObject metaObject = new MetaObject(messageId, stream);

        channelHandlerContext.writeAndFlush(metaObject);
    }

    public void onClose() {
        channelHandlerContext = null;
    }

    public boolean isActive() {
        return channelHandlerContext != null;
    }
}
