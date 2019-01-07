package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.model.PlayerModel;
import io.jochimsen.cahframework.protocol.object.message.response.StartGameResponse;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class StartGameResponseDecoder extends DecoderBase<StartGameResponse> {
    public StartGameResponseDecoder(final ProtocolInputStream rawMessage, final StartGameResponse startGameResponse) {
        super(rawMessage, startGameResponse);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.me = rawMessage.readProtocolObject(PlayerModel.class);
        protocolObject.player = rawMessage.readList(PlayerModel.class);
        protocolObject.sessionId = rawMessage.readUUID();
    }
}
