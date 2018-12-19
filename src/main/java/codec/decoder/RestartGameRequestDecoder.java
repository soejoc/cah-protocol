package codec.decoder;

import protocol.object.message.request.RestartGameRequest;
import util.ProtocolInputStream;

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
