package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.StartGameRequestDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.StartGameRequestEncoder;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public class StartGameRequest extends ProtocolMessage {
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new StartGameRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
