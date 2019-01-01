package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.request.RestartGameRequest;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class RestartGameRequestEncoder extends EncoderBase<RestartGameRequest> {
    public RestartGameRequestEncoder(final RestartGameRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.sessionKey);
    }
}
