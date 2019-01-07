package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class SelectCardResponse extends ProtocolMessage {
    public List<WhiteCardModel> whiteCardModelList;

    @Override
    public int getMessageId() {
        return MessageCode.SELECT_CARD_RS;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return null;
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return null;
    }
}
