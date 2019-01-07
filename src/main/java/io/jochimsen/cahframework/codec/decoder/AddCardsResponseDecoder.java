package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.response.AddCardsResponse;
import io.jochimsen.cahframework.protocol.object.model.BlackCardModel;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class AddCardsResponseDecoder extends DecoderBase<AddCardsResponse> {
    public AddCardsResponseDecoder(final ProtocolInputStream rawMessage, final AddCardsResponse protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.blackCardModel = rawMessage.readProtocolObject(BlackCardModel.class);
        protocolObject.whiteCardModels = rawMessage.readList(WhiteCardModel.class);
    }
}
