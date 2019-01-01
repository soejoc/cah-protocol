package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.request.RestartGameRequest;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class RestartGameRequestDecoder extends DecoderBase<RestartGameRequest> {
    public RestartGameRequestDecoder(final ProtocolInputStream rawMessage, final RestartGameRequest restartGameRequest) {
        super(rawMessage, restartGameRequest);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.sessionKey = rawMessage.readUUID();
    }
}
