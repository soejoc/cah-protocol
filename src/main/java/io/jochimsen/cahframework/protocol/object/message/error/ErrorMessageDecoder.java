package io.jochimsen.cahframework.protocol.object.message.error;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class ErrorMessageDecoder extends DecoderBase<ErrorMessage> {
    ErrorMessageDecoder(final ErrorMessage errorMessage) {
        super(errorMessage);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.errorCode = protocolInputStream.readInt();
        protocolObject.message = protocolInputStream.readString();
    }
}
