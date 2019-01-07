package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.model.BlackCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class BlackCardEncoder extends EncoderBase<BlackCardModel> {
    public BlackCardEncoder(final BlackCardModel protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(protocolObject.blackCardId);
    }
}
