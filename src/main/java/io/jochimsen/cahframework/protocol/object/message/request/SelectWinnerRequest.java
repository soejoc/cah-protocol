package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.SelectWinnerRequestDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.SelectWinnerRequestEncoder;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class SelectWinnerRequest extends ProtocolMessage {
    public List<WhiteCardModel> whiteCardModels;

    @Override
    public int getMessageId() {
        return MessageCode.SELECT_WINNER_RQ;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new SelectWinnerRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new SelectWinnerRequestEncoder(this);
    }
}
