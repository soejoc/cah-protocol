package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class StartGameRequest extends ProtocolMessage {
    private final String nickName;

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
