package io.jochimsen.cahframework.exception.internal;

public class ProtocolMessageSerializationException extends RuntimeException {
    private static final String MESSAGE = "The protocol message could not be serialized";

    public ProtocolMessageSerializationException(final Throwable cause) {
        super(MESSAGE, cause);
    }
}
