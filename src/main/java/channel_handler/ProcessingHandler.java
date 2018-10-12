package channel_handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import protocol.object.meta.MetaObject;
import session.Session;
import throwable.exception.InvalidInputStreamException;
import util.ProtocolInputStream;

public abstract class ProcessingHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        MetaObject metaObject = (MetaObject) msg;

        final int messageId = metaObject.getMessageId();
        final ProtocolInputStream rawMessage = metaObject.getStream();
        final Session session = getOrCreateSession(ctx);

        try {
            handleMessage(messageId, rawMessage, session);
        } catch (InvalidInputStreamException e) {
            session.close();
        }
    }

    protected abstract Session getOrCreateSession(final ChannelHandlerContext ctx);

    protected abstract void handleMessage(final int messageId, final ProtocolInputStream rawMessage, final Session session) throws InvalidInputStreamException;
}