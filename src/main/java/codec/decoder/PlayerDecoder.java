package codec.decoder;

import protocol.object.model.PlayerModel;
import util.ProtocolInputStream;

import java.io.IOException;

public class PlayerDecoder extends DecoderBase<PlayerModel> {
    public PlayerDecoder(final ProtocolInputStream rawMessage, final PlayerModel playerModel) {
        super(rawMessage, playerModel);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.playerId = rawMessage.readUUID();
        protocolObject.nickName = rawMessage.readString();
    }
}
