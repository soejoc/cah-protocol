package io.jochimsen.cahframework.protocol.error.error_message;

import io.jochimsen.cahframework.protocol.error.ErrorBase;
import io.jochimsen.cahframework.protocol.error.ErrorCode;

public class InvalidMessageException extends ErrorBase {
    public InvalidMessageException() {
        super("The received message is invalid.");
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.INVALID_MESSAGE;
    }
}
