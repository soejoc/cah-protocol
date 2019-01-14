package io.jochimsen.cahframework.protocol.object.message.error;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

/**
 * This io.jochimsen.cahframework.protocol object shall never be changed because it is used to signal errors to the communication partner.
 * It'players defined to be compatible across all io.jochimsen.cahframework.protocol versions.
 */
public class ErrorMessage extends ProtocolMessage {
    public int errorCode;
    public String message;

    @Override
    public int getMessageId() {
        return MessageCode.ERROR;
    }
}
