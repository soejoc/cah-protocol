package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.RequestMessage;
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
