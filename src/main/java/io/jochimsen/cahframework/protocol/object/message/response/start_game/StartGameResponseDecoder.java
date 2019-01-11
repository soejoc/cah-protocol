package io.jochimsen.cahframework.protocol.object.message.response.start_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.model.player.PlayerProtocolModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class StartGameResponseDecoder extends DecoderBase<StartGameResponse> {
    StartGameResponseDecoder(final StartGameResponse startGameResponse) {
        super(startGameResponse);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.players = protocolInputStream.readList(PlayerProtocolModel.class);
        protocolObject.sessionId = protocolInputStream.readUUID();
    }
}
