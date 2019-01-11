package io.jochimsen.cahframework.protocol.object.message.request.start_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

public class StartGameRequest extends ProtocolMessage {
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new StartGameRequestDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
