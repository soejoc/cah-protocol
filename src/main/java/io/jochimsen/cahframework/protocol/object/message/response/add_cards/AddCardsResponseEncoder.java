package io.jochimsen.cahframework.protocol.object.message.response.add_cards;

import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.model.white_card.WhiteCardProtocolModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

class AddCardsResponseEncoder extends EncoderBase<AddCardsResponse> {
    AddCardsResponseEncoder(final AddCardsResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    public void encode(final ProtocolOutputStream protocolOutputStream) throws IOException {
        protocolOutputStream.write(protocolObject.blackCardProtocolModel);
        protocolOutputStream.write(WhiteCardProtocolModel.class, protocolObject.whiteCardProtocolModels);
    }
}
