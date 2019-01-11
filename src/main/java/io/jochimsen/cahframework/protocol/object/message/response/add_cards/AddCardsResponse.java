package io.jochimsen.cahframework.protocol.object.message.response.add_cards;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.black_card.BlackCardProtocolModel;
import io.jochimsen.cahframework.protocol.object.model.white_card.WhiteCardProtocolModel;

import java.util.List;

public class AddCardsResponse extends ProtocolMessage {
    public BlackCardProtocolModel blackCardProtocolModel;
    public List<WhiteCardProtocolModel> whiteCardProtocolModels;

    @Override
    public int getMessageId() {
        return MessageCode.ADD_CARDS_RS;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new AddCardsResponseDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new AddCardsResponseEncoder(this);
    }
}
