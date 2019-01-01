package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.request.StartGameRequest;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class StartGameRequestEncoder extends EncoderBase<StartGameRequest> {
    public StartGameRequestEncoder(final StartGameRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.nickName);
    }
}
