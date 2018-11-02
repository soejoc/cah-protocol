package codec.decoder;

import protocol.object.model.PlayerModel;
import protocol.object.message.response.StartGameResponse;
import util.ProtocolInputStream;

import java.io.IOException;

public class StartGameResponseDecoder extends DecoderBase<StartGameResponse> {
    public StartGameResponseDecoder(final ProtocolInputStream rawMessage, final StartGameResponse startGameResponse) {
        super(rawMessage, startGameResponse);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.me = rawMessage.readProtocolObject(PlayerModel.class);
        protocolObject.antagonists = rawMessage.readList(PlayerModel.class);
    }
}
