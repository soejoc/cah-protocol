package io.jochimsen.cahframework.protocol.object.model.black_card;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;

public class BlackCardProtocolModel extends ProtocolObject {
    public long blackCardId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new BlackCardProtocolModelDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new BlackCardProtocolModelEncoder(this);
    }
}
