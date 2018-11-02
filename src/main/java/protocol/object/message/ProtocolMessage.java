package protocol.object.message;

import protocol.object.ProtocolObject;

public abstract class ProtocolMessage extends ProtocolObject {
    public abstract int getMessageId();
}
