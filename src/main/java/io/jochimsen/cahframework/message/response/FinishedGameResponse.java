package io.jochimsen.cahframework.message.response;

import io.jochimsen.cahframework.message.MessageCode;
import io.jochimsen.collo.protocol.ResponseMessage;

public class FinishedGameResponse extends ResponseMessage {

    @Override
    public int getMessageId() {
        return MessageCode.FINISHED_GAME_RS;
    }
}
