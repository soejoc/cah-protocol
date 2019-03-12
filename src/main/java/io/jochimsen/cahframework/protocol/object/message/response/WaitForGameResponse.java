package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.ResponseMessage;

public class WaitForGameResponse extends ResponseMessage {

    @Override
    public int getMessageId() {
        return MessageCode.WAIT_FOR_GAME_RS;
    }
}
