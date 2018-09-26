package codec.encoder;

import protocol.object.request.StartGameRequest;
import util.ProtocolOutputStream;

import java.io.IOException;

public class StartGameRequestEncoder extends EncoderBase<StartGameRequest> {
    public StartGameRequestEncoder(StartGameRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.nickName);
    }
}
