package io.jochimsen.cahframework.protocol.object.message;

import io.jochimsen.cahframework.protocol.ProtocolObject;

public abstract class ProtocolMessage extends ProtocolObject {
    public abstract int getMessageId();
}
