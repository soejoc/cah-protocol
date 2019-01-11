package io.jochimsen.cahframework.protocol.error.error_message;

import io.jochimsen.cahframework.protocol.error.ErrorBase;
import io.jochimsen.cahframework.protocol.error.ErrorCode;

public class InvalidProtocolVersionException extends ErrorBase {
    public InvalidProtocolVersionException(final int version, final int currentVersion) {
        super(String.format("Invalid io.jochimsen.cahframework.protocol version found! Expected version %d but found version %d", currentVersion, version));
    }

    @Override
    public int getErrorCode() {
        return ErrorCode.INVALID_PROTOCOL_VERSION;
    }
}
