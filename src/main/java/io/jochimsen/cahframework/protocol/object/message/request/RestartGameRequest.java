package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.RestartGameRequestDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.RestartGameRequestEncoder;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.UUID;

public class RestartGameRequest extends ProtocolMessage {
    public UUID sessionKey;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new RestartGameRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new RestartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.RESTART_GAME_RQ;
    }
}
