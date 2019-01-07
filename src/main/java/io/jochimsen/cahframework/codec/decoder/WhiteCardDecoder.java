package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class WhiteCardDecoder extends DecoderBase<WhiteCardModel> {
    public WhiteCardDecoder(final ProtocolInputStream rawMessage, final WhiteCardModel protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.whiteCardId = rawMessage.readLong();
    }
}
