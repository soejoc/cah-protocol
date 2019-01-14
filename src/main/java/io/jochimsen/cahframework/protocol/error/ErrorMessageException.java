package io.jochimsen.cahframework.protocol.error;

/**
 * This base class shall be used to signal exceptions to the communication partner.
 */
public abstract class ErrorMessageException extends RuntimeException {

    public ErrorMessageException(final String message) {
        super(message);
    }

    public ErrorMessageException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public abstract int getErrorCode();
}
