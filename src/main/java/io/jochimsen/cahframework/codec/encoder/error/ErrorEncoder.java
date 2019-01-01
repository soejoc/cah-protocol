package io.jochimsen.cahframework.codec.encoder.error;

import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorObject;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class ErrorEncoder extends EncoderBase<ErrorObject> {
    public ErrorEncoder(final ErrorObject errorObject) {
        super(errorObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.errorCode)
                .write(protocolObject.message);
    }
}
