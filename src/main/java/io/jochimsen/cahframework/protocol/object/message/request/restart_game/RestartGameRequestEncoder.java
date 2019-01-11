package io.jochimsen.cahframework.protocol.object.message.request.restart_game;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

class RestartGameRequestEncoder extends EncoderBase<RestartGameRequest> {
    RestartGameRequestEncoder(final RestartGameRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream
                .write(protocolObject.sessionKey);
    }
}
