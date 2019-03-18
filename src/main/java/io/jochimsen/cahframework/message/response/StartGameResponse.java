package io.jochimsen.cahframework.message.response;

import io.jochimsen.cahframework.message.MessageCode;
import io.jochimsen.cahframework.model.PlayerProtocolModel;
import io.jochimsen.collo.protocol.ResponseMessage;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = false)
public class StartGameResponse extends ResponseMessage {
    private final List<PlayerProtocolModel> players;
    private final UUID sessionId;

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
