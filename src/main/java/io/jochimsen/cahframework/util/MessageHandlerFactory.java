package io.jochimsen.cahframework.util;

import io.jochimsen.cahframework.handler.message.MessageHandler;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.session.Session;

public interface MessageHandlerFactory<M extends ProtocolMessage, S extends Session> {
    MessageHandler<? extends M, S> create(final Class<? extends MessageHandler<? extends M, S>> clazz);
}
