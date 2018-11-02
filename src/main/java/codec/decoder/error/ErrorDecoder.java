package codec.decoder.error;

import codec.decoder.DecoderBase;
import protocol.object.message.error.ErrorObject;
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
