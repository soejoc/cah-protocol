package codec.decoder.error;

import codec.decoder.DecoderBase;
import protocol.object.error.ErrorObject;
import protocol.object.request.StartGameRequest;
import util.ProtocolInputStream;

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
