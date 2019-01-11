package io.jochimsen.cahframework.handler;

import io.jochimsen.cahframework.util.ProtocolStream;

public class SerializedProtocolMessage {
    private final int messageId;
    private final ProtocolStream protocolStream;

    public SerializedProtocolMessage(final int messageId, final ProtocolStream protocolStream) {
        this.messageId = messageId;
        this.protocolStream = protocolStream;
    }

    public int getMessageId() {
        return messageId;
    }

    public ProtocolStream getProtocolStream() {
        return protocolStream;
    }
}
