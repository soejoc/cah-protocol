package protocol.error.exception;

import protocol.error.ErrorCode;

public class InvalidMessageException extends ErrorBase {
    public InvalidMessageException() {
        super("The received message is invalid.");
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.INVALID_MESSAGE;
    }
}
