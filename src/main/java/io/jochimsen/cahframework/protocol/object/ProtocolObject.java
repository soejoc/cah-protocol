package io.jochimsen.cahframework.protocol.object;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.error.exception.InvalidMessageException;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public abstract class ProtocolObject {
    protected abstract DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream);
    protected abstract EncoderBase<? extends ProtocolObject> getEncoder();

    public void fromStream(final ProtocolInputStream protocolObjectStream) {
        try {
            final DecoderBase<? extends ProtocolObject> decoder = getDecoder(protocolObjectStream);

            if(decoder != null) {
                decoder.decode();
            }
        } catch (final IOException e) {
            throw new InvalidMessageException();
        }
    }

    public byte[] toRawObject() {
        final EncoderBase<? extends ProtocolObject> encoder = getEncoder();
        return (encoder != null) ? encoder.encode() : null;
    }
}
