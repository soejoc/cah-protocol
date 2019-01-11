package io.jochimsen.cahframework.protocol.object.message.response.start_game;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.model.player.PlayerProtocolModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

class StartGameResponseEncoder extends EncoderBase<StartGameResponse> {
    StartGameResponseEncoder(final StartGameResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream
                .write(PlayerProtocolModel.class, protocolObject.players)
                .write(protocolObject.sessionId);
    }
}
