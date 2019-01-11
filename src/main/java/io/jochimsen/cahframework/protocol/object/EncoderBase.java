package io.jochimsen.cahframework.protocol.object;

import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public abstract class EncoderBase<T extends ProtocolObject> {
    protected final T protocolObject;

    public EncoderBase(final T protocolObject) {
        this.protocolObject = protocolObject;
    }

    public abstract void encode(final ProtocolOutputStream protocolOutputStream) throws IOException;
}
