package io.jochimsen.cahframework.protocol.object.message.response.finished_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;

public class FinishedGameResponse extends ProtocolMessage {

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return null;
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return null;
    }

    @Override
    public int getMessageId() {
        return MessageCode.FINISHED_GAME_RS;
    }
}
