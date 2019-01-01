package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.StartGameResponseDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.StartGameResponseEncoder;
import io.jochimsen.cahframework.protocol.object.model.PlayerModel;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;
import java.util.UUID;

public class StartGameResponse extends ProtocolMessage {
    public PlayerModel me;
    public List<PlayerModel> antagonists;
    public UUID sessionId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new StartGameResponseDecoder(protocolObjectStream, this);
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
