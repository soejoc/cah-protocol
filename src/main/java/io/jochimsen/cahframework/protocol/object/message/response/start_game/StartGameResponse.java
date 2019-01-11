package io.jochimsen.cahframework.protocol.object.message.response.start_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.player.PlayerProtocolModel;

import java.util.List;
import java.util.UUID;

public class StartGameResponse extends ProtocolMessage {
    public List<PlayerProtocolModel> players;
    public UUID sessionId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new StartGameResponseDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameResponseEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
