package io.jochimsen.cahframework.protocol.object.model.black_card;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class BlackCardProtocolModelDecoder extends DecoderBase<BlackCardProtocolModel> {
    BlackCardProtocolModelDecoder(final BlackCardProtocolModel protocolObject) {
        super(protocolObject);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.blackCardId = protocolInputStream.readLong();
    }
}