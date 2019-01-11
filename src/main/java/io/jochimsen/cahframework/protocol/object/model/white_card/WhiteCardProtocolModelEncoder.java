package io.jochimsen.cahframework.protocol.object.model.white_card;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class WhiteCardProtocolModelEncoder extends EncoderBase<WhiteCardProtocolModel> {
    public WhiteCardProtocolModelEncoder(final WhiteCardProtocolModel protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream.write(protocolObject.whiteCardsId);
    }
}
