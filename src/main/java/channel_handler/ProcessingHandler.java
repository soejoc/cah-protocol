package channel_handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import protocol.MessageCode;
import protocol.error.exception.ErrorBase;
import protocol.object.error.ErrorObject;
import protocol.object.meta.MetaObject;
import session.Session;
import util.ProtocolInputStream;

public abstract class ProcessingHandler extends ChannelInboundHandlerAdapter {

    @Override
    public final void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        final MetaObject metaObject = (MetaObject) msg;

        final int messageId = metaObject.getMessageId();
        final ProtocolInputStream rawMessage = metaObject.getStream();
        final Session session = getSession(ctx);

        if(messageId == MessageCode.ERROR) {
            ErrorObject errorObject = new ErrorObject();
            errorObject.fromStream(rawMessage);

            onErrorReceived(errorObject, session);
        } else {
            handleMessage(messageId, rawMessage, session);
        }
    }

    @Override
    public final void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
        final Session session = getSession(ctx);

        if(cause instanceof ErrorBase) {
            final ErrorObject errorObject = new ErrorObject();
            errorObject.errorCode = ((ErrorBase) cause).getErrorCode();
            errorObject.message = cause.getMessage();

            session.say(errorObject);
            session.close();
        } else {
            super.exceptionCaught(ctx, cause);
        }
    }

    protected abstract Session getSession(final ChannelHandlerContext ctx);

    protected abstract void handleMessage(final int messageId, final ProtocolInputStream rawMessage, final Session session);

    protected abstract void onErrorReceived(final ErrorObject errorObject, final Session session);
}