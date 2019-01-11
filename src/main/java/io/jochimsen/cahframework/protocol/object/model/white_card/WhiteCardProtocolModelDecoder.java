package io.jochimsen.cahframework.protocol.object.model.white_card;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class WhiteCardProtocolModelDecoder extends DecoderBase<WhiteCardProtocolModel> {
    WhiteCardProtocolModelDecoder(final WhiteCardProtocolModel protocolObject) {
        super(protocolObject);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.whiteCardsId = protocolInputStream.readLong();
    }
}
