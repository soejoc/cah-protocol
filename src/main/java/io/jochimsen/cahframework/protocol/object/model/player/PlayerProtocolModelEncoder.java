package io.jochimsen.cahframework.protocol.object.model.player;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class PlayerProtocolModelEncoder extends EncoderBase<PlayerProtocolModel> {
    public PlayerProtocolModelEncoder(final PlayerProtocolModel playerProtocolModel) {
        super(playerProtocolModel);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream
                .write(protocolObject.playerId)
                .write(protocolObject.nickName);
    }
}
