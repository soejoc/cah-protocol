package io.jochimsen.cahframework.protocol.object.model;

import io.jochimsen.cahframework.codec.decoder.BlackCardDecoder;
import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.BlackCardEncoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public class BlackCardModel extends ProtocolObject {
    public long blackCardId;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new BlackCardDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new BlackCardEncoder(this);
    }
}
