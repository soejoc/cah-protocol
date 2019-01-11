package io.jochimsen.cahframework.protocol.object.message.request.start_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class StartGameRequestDecoder extends DecoderBase<StartGameRequest> {
    StartGameRequestDecoder(final StartGameRequest startGameRequest) {
        super(startGameRequest);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.nickName = protocolInputStream.readString();
    }
}
