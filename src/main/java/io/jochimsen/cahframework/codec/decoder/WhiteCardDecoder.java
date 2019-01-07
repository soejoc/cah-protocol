package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.model.WhiteCard;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class WhiteCardDecoder extends DecoderBase<WhiteCard> {
    public WhiteCardDecoder(final ProtocolInputStream rawMessage, final WhiteCard protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.whiteCardsId = rawMessage.readLong();
    }
}
