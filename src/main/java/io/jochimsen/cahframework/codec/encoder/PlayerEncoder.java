package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.model.PlayerModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class PlayerEncoder extends EncoderBase<PlayerModel> {
    public PlayerEncoder(final PlayerModel playerModel) {
        super(playerModel);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.playerId)
                .write(protocolObject.nickName);
    }
}
