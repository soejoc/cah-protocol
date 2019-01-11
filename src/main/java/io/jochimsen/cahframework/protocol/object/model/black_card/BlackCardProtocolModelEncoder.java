package io.jochimsen.cahframework.protocol.object.model.black_card;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

class BlackCardProtocolModelEncoder extends EncoderBase<BlackCardProtocolModel> {
    BlackCardProtocolModelEncoder(final BlackCardProtocolModel protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream.write(protocolObject.blackCardId);
    }
}
