package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.model.WhiteCard;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class WhiteCardEncoder extends EncoderBase<WhiteCard> {
    public WhiteCardEncoder(final WhiteCard protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(protocolObject.whiteCardsId);
    }
}
