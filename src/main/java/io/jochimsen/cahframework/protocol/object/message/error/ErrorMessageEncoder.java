package io.jochimsen.cahframework.protocol.object.message.error;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class ErrorMessageEncoder extends EncoderBase<ErrorMessage> {
    public ErrorMessageEncoder(final ErrorMessage errorMessage) {
        super(errorMessage);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream
                .write(protocolObject.errorCode)
                .write(protocolObject.message);
    }
}
