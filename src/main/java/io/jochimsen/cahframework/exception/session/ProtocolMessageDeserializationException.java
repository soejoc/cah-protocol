package io.jochimsen.cahframework.exception.session;

public class ProtocolMessageDeserializationException extends SessionException {
    private static final String MESSAGE = "The protocol message is could not be deserialized";

    public ProtocolMessageDeserializationException(final Throwable cause) {
        super(MESSAGE, cause);
    }
}
