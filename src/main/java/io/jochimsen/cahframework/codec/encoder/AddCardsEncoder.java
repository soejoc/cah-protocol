package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.response.AddCardsResponse;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class AddCardsEncoder extends EncoderBase<AddCardsResponse> {
    public AddCardsEncoder(final AddCardsResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(protocolObject.blackCardModel);
        stream.write(WhiteCardModel.class, protocolObject.whiteCardModels);
    }
}
