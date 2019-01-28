package io.jochimsen.cahframework.protocol.object.message.error;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

/**
 * This io.jochimsen.cahframework.protocol object shall never be changed because it is used to signal errors to the communication partner.
 * It'players defined to be compatible across all io.jochimsen.cahframework.protocol versions.
 */
public class ErrorMessage extends ProtocolMessage {
    private final int errorCode;
    private final String message;

    public ErrorMessage(final int errorCode, final String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int getMessageId() {
        return MessageCode.ERROR;
    }
}
