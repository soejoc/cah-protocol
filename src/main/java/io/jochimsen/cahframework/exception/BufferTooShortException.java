package io.jochimsen.cahframework.exception;

public class BufferTooShortException extends RuntimeException {
    public BufferTooShortException(final String message) {
        super(message);
    }
}
