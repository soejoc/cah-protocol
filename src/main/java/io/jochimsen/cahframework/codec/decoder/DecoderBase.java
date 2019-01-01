package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

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
