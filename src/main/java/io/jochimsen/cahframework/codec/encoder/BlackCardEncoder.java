package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.model.BlackCard;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class BlackCardEncoder extends EncoderBase<BlackCard> {
    public BlackCardEncoder(final BlackCard protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(protocolObject.blackCardId);
    }
}
