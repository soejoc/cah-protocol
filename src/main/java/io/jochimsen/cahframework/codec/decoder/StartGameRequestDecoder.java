package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.request.StartGameRequest;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class StartGameRequestDecoder extends DecoderBase<StartGameRequest> {
    public StartGameRequestDecoder(final ProtocolInputStream rawMessage, final StartGameRequest startGameRequest) {
        super(rawMessage, startGameRequest);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.nickName = rawMessage.readString();
    }
}
