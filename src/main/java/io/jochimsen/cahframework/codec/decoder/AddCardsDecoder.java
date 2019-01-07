package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.response.AddCardsResponse;
import io.jochimsen.cahframework.protocol.object.model.BlackCard;
import io.jochimsen.cahframework.protocol.object.model.WhiteCard;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class AddCardsDecoder extends DecoderBase<AddCardsResponse> {
    public AddCardsDecoder(final ProtocolInputStream rawMessage, final AddCardsResponse protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.blackCard = rawMessage.readProtocolObject(BlackCard.class);
        protocolObject.whiteCards = rawMessage.readList(WhiteCard.class);
    }
}
