package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.util.ProtocolInputStream;

public class RawProtocolMessageInput {
    private final int messageId;
    private final ProtocolInputStream protocolInputStream;

    public RawProtocolMessageInput(final int messageId, final ProtocolInputStream protocolInputStream) {
        this.messageId = messageId;
        this.protocolInputStream = protocolInputStream;
    }

    public int getMessageId() {
        return messageId;
    }

    public ProtocolInputStream getProtocolInputStream() {
        return protocolInputStream;
    }
}
