package codec.encoder;

import protocol.object.ProtocolObject;
import throwable.error.EncodingError;
import util.ProtocolOutputStream;

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
        } catch (IOException e) {
            throw new EncodingError("Could not encode the protocol object");
        }
    }

    protected abstract void serialize(final ProtocolOutputStream stream) throws IOException;
}
