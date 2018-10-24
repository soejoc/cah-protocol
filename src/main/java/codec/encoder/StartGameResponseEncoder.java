package codec.encoder;

import protocol.object.response.StartGameResponse;
import util.ProtocolOutputStream;

import java.io.IOException;

public class StartGameResponseEncoder extends EncoderBase<StartGameResponse> {
    public StartGameResponseEncoder(final StartGameResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.nickName);
    }
}
