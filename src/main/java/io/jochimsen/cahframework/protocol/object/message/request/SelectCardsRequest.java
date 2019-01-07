package io.jochimsen.cahframework.protocol.object.message.request;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.decoder.SelectCardsRequestDecoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.codec.encoder.SelectCardsRequestEncoder;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class SelectCardsRequest extends ProtocolMessage {
    public List<WhiteCardModel> whiteCardModels;

    @Override
    public int getMessageId() {
        return MessageCode.SELECT_CARDS_RQ;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new SelectCardsRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new SelectCardsRequestEncoder(this);
    }
}
