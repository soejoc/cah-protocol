package io.jochimsen.cahframework.handler.message;

import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.session.Session;

public interface MessageHandler<M extends ProtocolMessage, S extends Session> {
    void handleMessage(final M protocolMessage, final S session);
}
