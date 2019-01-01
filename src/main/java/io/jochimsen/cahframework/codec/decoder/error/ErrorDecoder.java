package io.jochimsen.cahframework.codec.decoder.error;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.protocol.object.message.error.ErrorObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class ErrorDecoder extends DecoderBase<ErrorObject> {
    public ErrorDecoder(final ProtocolInputStream rawMessage, final ErrorObject errorObject) {
        super(rawMessage, errorObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.errorCode = rawMessage.readInt();
        protocolObject.message = rawMessage.readString();
    }
}
