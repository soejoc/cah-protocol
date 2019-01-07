package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.codec.decoder.AddCardsDecoder;
import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.AddCardsEncoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.BlackCard;
import io.jochimsen.cahframework.protocol.object.model.WhiteCard;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class AddCardsResponse extends ProtocolMessage {
    public BlackCard blackCard;
    public List<WhiteCard> whiteCards;

    @Override
    public int getMessageId() {
        return MessageCode.ADD_CARDS_RS;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new AddCardsDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new AddCardsEncoder(this);
    }
}
