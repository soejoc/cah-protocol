package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

public class FinishedGameResponse extends ProtocolMessage {

    @Override
    public int getMessageId() {
        return MessageCode.FINISHED_GAME_RS;
    }
}
