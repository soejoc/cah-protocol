package io.jochimsen.cahframework.protocol.object.message;

import java.io.Serializable;

public abstract class ProtocolMessage implements Serializable {
    public abstract int getMessageId();
}
