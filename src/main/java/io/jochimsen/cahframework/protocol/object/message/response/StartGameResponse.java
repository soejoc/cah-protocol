package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.PlayerProtocolModel;

import java.util.List;
import java.util.UUID;

public class StartGameResponse extends ProtocolMessage {
    public List<PlayerProtocolModel> players;
    public UUID sessionId;

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
