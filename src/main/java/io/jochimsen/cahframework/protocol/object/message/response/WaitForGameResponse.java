package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

public class WaitForGameResponse extends ProtocolMessage {

    @Override
    public int getMessageId() {
        return MessageCode.WAIT_FOR_GAME_RS;
    }
}
