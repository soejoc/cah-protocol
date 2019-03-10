package io.jochimsen.cahframework.handler.message;

import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import lombok.RequiredArgsConstructor;

public abstract class MessageHandler<T extends ProtocolMessage> {
    public abstract void handle(final T protocolMessage);
}
