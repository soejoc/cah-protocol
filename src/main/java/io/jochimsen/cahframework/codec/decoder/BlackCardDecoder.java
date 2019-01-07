package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.model.BlackCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class BlackCardDecoder extends DecoderBase<BlackCardModel> {
    public BlackCardDecoder(final ProtocolInputStream rawMessage, final BlackCardModel protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.blackCardId = rawMessage.readLong();
    }
}
