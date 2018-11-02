package codec.encoder.error;

import codec.encoder.EncoderBase;
import protocol.object.message.error.ErrorObject;
import util.ProtocolOutputStream;

import java.io.IOException;

public class ErrorEncoder extends EncoderBase<ErrorObject> {
    public ErrorEncoder(final ErrorObject errorObject) {
        super(errorObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream
                .write(protocolObject.errorCode)
                .write(protocolObject.message);
    }
}
