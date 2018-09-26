package codec.decoder;

import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

import java.io.IOException;

public abstract class DecoderBase<T extends ProtocolObject> {
    protected final ProtocolInputStream rawMessage;
    public final T protocolObject;

    public DecoderBase(final ProtocolInputStream rawMessage, final T protocolObject) {
        this.rawMessage = rawMessage;
        this.protocolObject = protocolObject;
    }

    public abstract void decode() throws IOException;
}
