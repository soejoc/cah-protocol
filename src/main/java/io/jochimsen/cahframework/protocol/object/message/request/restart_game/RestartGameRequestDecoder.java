package io.jochimsen.cahframework.protocol.object.message.request.restart_game;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class RestartGameRequestDecoder extends DecoderBase<RestartGameRequest> {
    RestartGameRequestDecoder(final RestartGameRequest restartGameRequest) {
        super(restartGameRequest);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.sessionKey = protocolInputStream.readUUID();
    }
}
