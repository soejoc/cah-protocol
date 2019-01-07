package io.jochimsen.cahframework.protocol.object.model;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.WhiteCardDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.WhiteCardEncoder;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public class WhiteCard extends ProtocolObject {
    public long whiteCardsId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new WhiteCardDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new WhiteCardEncoder(this);
    }
}
