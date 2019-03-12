package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.RequestMessage;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = false)
public class RestartGameRequest extends RequestMessage {
    private final UUID sessionKey;

    @Override
    public int getMessageId() {
        return MessageCode.RESTART_GAME_RQ;
    }
}
