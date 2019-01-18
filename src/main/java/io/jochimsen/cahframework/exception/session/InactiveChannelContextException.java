package io.jochimsen.cahframework.exception.session;

public class InactiveChannelContextException extends SessionException {
    private static final String MESSAGE = "The channel is inactive";

    public InactiveChannelContextException() {
        super(MESSAGE);
    }
}
