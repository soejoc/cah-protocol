package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.model.BlackCard;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class BlackCardDecoder extends DecoderBase<BlackCard> {
    public BlackCardDecoder(final ProtocolInputStream rawMessage, final BlackCard protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.blackCardId = rawMessage.readLong();
    }
}
