package io.jochimsen.cahframework.protocol.object.model.white_card;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;

public class WhiteCardProtocolModel extends ProtocolObject {
    public long whiteCardsId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new WhiteCardProtocolModelDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new WhiteCardProtocolModelEncoder(this);
    }
}
