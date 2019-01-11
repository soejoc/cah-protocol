package io.jochimsen.cahframework.protocol.object.model.player;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class PlayerProtocolModelDecoder extends DecoderBase<PlayerProtocolModel> {
    public PlayerProtocolModelDecoder(final PlayerProtocolModel playerProtocolModel) {
        super(playerProtocolModel);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.playerId = protocolInputStream.readUUID();
        protocolObject.nickName = protocolInputStream.readString();
    }
}
