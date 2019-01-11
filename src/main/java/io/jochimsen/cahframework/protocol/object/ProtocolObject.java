package io.jochimsen.cahframework.protocol.object;

import io.jochimsen.cahframework.exception.EncodingException;
import io.jochimsen.cahframework.protocol.error.error_message.InvalidMessageException;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public abstract class ProtocolObject {
    protected abstract DecoderBase<? extends ProtocolObject> getDecoder();
    protected abstract EncoderBase<? extends ProtocolObject> getEncoder();

    public boolean hasCodec() {
        return (getDecoder() != null && getEncoder() != null);
    }

    public void deserialize(final ProtocolInputStream protocolInputStream) {
        try {
            final DecoderBase<? extends ProtocolObject> decoder = getDecoder();

            if(decoder != null) {
                decoder.decode(protocolInputStream);
            }
        } catch (final IOException e) {
            throw new InvalidMessageException();
        }
    }

    public void serialize(final ProtocolOutputStream protocolOutputStream) {
        try {
            final EncoderBase<? extends ProtocolObject> encoder = getEncoder();

            if(encoder != null) {
                encoder.encode(protocolOutputStream);
            }
        } catch (final IOException e) {
            throw new EncodingException("Could not serialize protocol object", e);
        }
    }
}
