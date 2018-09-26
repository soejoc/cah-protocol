package protocol.object;

import codec.decoder.DecoderBase;
import codec.encoder.EncoderBase;
import throwable.exception.InvalidInputStreamException;
import util.ProtocolInputStream;

import java.io.IOException;

public abstract class ProtocolObject {
    protected abstract DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream);
    protected abstract EncoderBase<? extends ProtocolObject> getEncoder();

    public void fromStream(final ProtocolInputStream protocolObjectStream) throws InvalidInputStreamException {
        try {
            DecoderBase<? extends ProtocolObject> decoder = getDecoder(protocolObjectStream);
            decoder.decode();
        } catch (IOException e) {
            throw new InvalidInputStreamException("The provided input stream is not valid");
        }
    }

    public byte[] toRawObject() {
        EncoderBase<? extends ProtocolObject> encoder = getEncoder();
        return encoder.encode();
    }

    public abstract int getMessageId();
}
