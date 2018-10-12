package protocol.error.exception;

import protocol.error.ErrorCode;

public class InvalidProtocolVersionException extends ErrorBase {
    public InvalidProtocolVersionException(final int version, final int currentVersion) {
        super(String.format("Invalid protocol version found! Expected version %d but found version %d", currentVersion, version));
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.INVALID_PROTOCOL_VERSION;
    }
}
