package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.ResponseMessage;

public class FinishedGameResponse extends ResponseMessage {

    @Override
    public int getMessageId() {
        return MessageCode.FINISHED_GAME_RS;
    }
}
