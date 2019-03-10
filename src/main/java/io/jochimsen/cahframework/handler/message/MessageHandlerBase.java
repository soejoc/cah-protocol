package io.jochimsen.cahframework.handler.message;

import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class MessageHandlerBase<T extends ProtocolMessage> {
    protected final T protocolMessage;

    public abstract void handle();
}
