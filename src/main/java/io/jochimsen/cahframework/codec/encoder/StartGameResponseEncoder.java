package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.model.PlayerModel;
import io.jochimsen.cahframework.protocol.object.message.response.StartGameResponse;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class StartGameResponseEncoder extends EncoderBase<StartGameResponse> {
    public StartGameResponseEncoder(final StartGameResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.me)
                .write(PlayerModel.class, protocolObject.player)
                .write(protocolObject.sessionId);
    }
}
