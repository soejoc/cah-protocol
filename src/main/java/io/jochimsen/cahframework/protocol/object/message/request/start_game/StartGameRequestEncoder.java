package io.jochimsen.cahframework.protocol.object.message.request.start_game;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

class StartGameRequestEncoder extends EncoderBase<StartGameRequest> {
    StartGameRequestEncoder(final StartGameRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream
                .write(protocolObject.nickName);
    }
}
