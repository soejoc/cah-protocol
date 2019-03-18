package io.jochimsen.cahprotocol.message.request;

import io.jochimsen.cahprotocol.message.MessageCode;
import io.jochimsen.collo.protocol.RequestMessage;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class StartGameRequest extends RequestMessage {
    private final String nickName;

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
