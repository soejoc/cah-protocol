package io.jochimsen.cahframework.protocol.object.message.response.add_cards;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.model.black_card.BlackCardProtocolModel;
import io.jochimsen.cahframework.protocol.object.model.white_card.WhiteCardProtocolModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

class AddCardsResponseDecoder extends DecoderBase<AddCardsResponse> {
    AddCardsResponseDecoder(final AddCardsResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    public void decode(final ProtocolInputStream protocolInputStream) throws IOException {
        protocolObject.blackCardProtocolModel = protocolInputStream.readProtocolObject(BlackCardProtocolModel.class);
        protocolObject.whiteCardProtocolModels = protocolInputStream.readList(WhiteCardProtocolModel.class);
    }
}
