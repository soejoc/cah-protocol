package io.jochimsen.cahframework.protocol.object.message.request.restart_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

import java.util.UUID;

public class RestartGameRequest extends ProtocolMessage {
    public UUID sessionKey;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new RestartGameRequestDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new RestartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.RESTART_GAME_RQ;
    }
}
