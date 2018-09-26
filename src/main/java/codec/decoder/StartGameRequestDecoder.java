package codec.decoder;

import protocol.object.request.StartGameRequest;
import util.ProtocolInputStream;

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
