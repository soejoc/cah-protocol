package io.jochimsen.cahframework.session;

import io.netty.channel.ChannelHandlerContext;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.meta.MetaObject;
import io.jochimsen.cahframework.throwable.exception.InactiveChannelContextException;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public abstract class Session {
    protected ChannelHandlerContext channelHandlerContext;

    public Session(final ChannelHandlerContext channelHandlerContext) {
        this.channelHandlerContext = channelHandlerContext;
    }

    public ChannelHandlerContext getChannelHandlerContext() {
        return channelHandlerContext;
    }

    public void setChannelHandlerContext(final ChannelHandlerContext channelHandlerContext) {
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
