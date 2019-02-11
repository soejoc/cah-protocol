package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.PlayerProtocolModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = false)
public class StartGameResponse extends ProtocolMessage {
    private final List<PlayerProtocolModel> players;
    private final UUID sessionId;

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
