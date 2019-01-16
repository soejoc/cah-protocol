package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

import java.util.UUID;

public class RestartGameRequest extends ProtocolMessage {
    private final UUID sessionKey;

    public RestartGameRequest(final UUID sessionKey) {
        this.sessionKey = sessionKey;
    }

    public UUID getSessionKey() {
        return sessionKey;
    }

    @Override
    public int getMessageId() {
        return MessageCode.RESTART_GAME_RQ;
    }
}
