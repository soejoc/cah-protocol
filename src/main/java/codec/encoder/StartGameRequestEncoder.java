package codec.encoder;

import protocol.object.message.request.StartGameRequest;
import protocol.object.model.PlayerModel;
import util.ProtocolOutputStream;

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
