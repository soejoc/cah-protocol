package io.jochimsen.cahframework.protocol.error.exception;

/**
 * This base class shall be used to signal exceptions to the communication partner.
 */
public abstract class ErrorBase extends RuntimeException {
    public ErrorBase(final String message) {
        super(message);
    }

    public abstract int getErrorCode();
}
