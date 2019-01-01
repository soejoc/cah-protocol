package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.util.ProtocolInputStream;

public class FinishedGameResponse extends ProtocolMessage {

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return null;
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return null;
    }

    @Override
    public int getMessageId() {
        return MessageCode.FINISHED_GAME_RS;
    }
}
