package protocol.object;

import codec.decoder.DecoderBase;
import codec.encoder.EncoderBase;
import protocol.error.exception.InvalidMessageException;
import util.ProtocolInputStream;

import java.io.IOException;

public abstract class ProtocolObject {
    protected abstract DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream);
    protected abstract EncoderBase<? extends ProtocolObject> getEncoder();

    public void fromStream(final ProtocolInputStream protocolObjectStream) {
        try {
            final DecoderBase<? extends ProtocolObject> decoder = getDecoder(protocolObjectStream);
            decoder.decode();
        } catch (final IOException e) {
            throw new InvalidMessageException();
        }
    }

    public byte[] toRawObject() {
        final EncoderBase<? extends ProtocolObject> encoder = getEncoder();
        return (encoder != null) ? encoder.encode() : null;
    }

    public abstract int getMessageId();
}
