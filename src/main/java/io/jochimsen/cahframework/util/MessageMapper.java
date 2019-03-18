package io.jochimsen.cahframework.util;

import io.jochimsen.cahframework.handler.message.MessageHandler;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.session.Session;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface MessageMapper<M extends ProtocolMessage, S extends Session> {
    Pair<M, S> map(final int messageId);

    @RequiredArgsConstructor
    @Getter
    class Pair<M extends ProtocolMessage, S extends Session> {
        private final Class<? extends M> messageClass;
        private final Class<? extends MessageHandler<? extends M, S>> messageHandlerClass;
    }
}
