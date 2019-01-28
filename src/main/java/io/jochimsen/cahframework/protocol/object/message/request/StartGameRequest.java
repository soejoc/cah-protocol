package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

public class StartGameRequest extends ProtocolMessage {
    private final String nickName;

    public StartGameRequest(final String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
