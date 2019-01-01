package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.throwable.error.EncodingError;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public abstract class EncoderBase<T extends ProtocolObject> {
    protected final T protocolObject;

    public EncoderBase(final T protocolObject) {
        this.protocolObject = protocolObject;
    }

    public byte[] encode() {
        try {
            final ProtocolOutputStream rawDataStream = new ProtocolOutputStream();
            serialize(rawDataStream);
            rawDataStream.flush();

            return rawDataStream.toByteArray();
        } catch (final IOException e) {
            throw new EncodingError("Could not encode the io.jochimsen.cahframework.protocol object");
        }
    }

    protected abstract void serialize(final ProtocolOutputStream stream) throws IOException;
}
