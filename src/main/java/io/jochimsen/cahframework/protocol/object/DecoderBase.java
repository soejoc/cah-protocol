package io.jochimsen.cahframework.protocol.object;

import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public abstract class DecoderBase<T extends ProtocolObject> {
    public final T protocolObject;

    public DecoderBase(final T protocolObject) {
        this.protocolObject = protocolObject;
    }

    public abstract void decode(final ProtocolInputStream protocolInputStream) throws IOException;
}
