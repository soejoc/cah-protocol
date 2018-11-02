package protocol.object.message.error;

import codec.decoder.DecoderBase;
import codec.decoder.error.ErrorDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.error.ErrorEncoder;
import protocol.object.message.ProtocolMessage;
import protocol.object.message.MessageCode;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

/**
 * This protocol object shall never be changed because it is used to signal errors to the communication partner.
 * It's defined to be compatible across all protocol versions.
 */
public class ErrorObject extends ProtocolMessage {
    public int errorCode;
    public String message;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new ErrorDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new ErrorEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.ERROR;
    }
}
