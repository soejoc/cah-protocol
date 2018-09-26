package protocol.object.meta;

import util.ProtocolInputStream;

public class MetaObject {
    private final int messageId;
    private final ProtocolInputStream stream;

    public MetaObject(final int messageId, final ProtocolInputStream stream) {
        this.messageId = messageId;
        this.stream = stream;
    }

    public int getMessageId() {
        return messageId;
    }

    public ProtocolInputStream getStream() {
        return stream;
    }
}
