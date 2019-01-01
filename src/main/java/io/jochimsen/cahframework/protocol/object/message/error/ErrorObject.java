package io.jochimsen.cahframework.protocol.object.message.error;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.error.ErrorDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.error.ErrorEncoder;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

/**
 * This io.jochimsen.cahframework.protocol object shall never be changed because it is used to signal errors to the communication partner.
 * It's defined to be compatible across all io.jochimsen.cahframework.protocol versions.
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
