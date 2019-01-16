package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.PlayerProtocolModel;

import java.util.List;
import java.util.UUID;

public class StartGameResponse extends ProtocolMessage {
    private final List<PlayerProtocolModel> players;
    private final UUID sessionId;

    public StartGameResponse(final List<PlayerProtocolModel> players, final UUID sessionId) {
        this.players = players;
        this.sessionId = sessionId;
    }

    public List<PlayerProtocolModel> getPlayers() {
        return players;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
