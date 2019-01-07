package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.request.SelectCardsRequest;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class SelectCardsRequestEncoder extends EncoderBase<SelectCardsRequest> {
    public SelectCardsRequestEncoder(final SelectCardsRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(WhiteCardModel.class, protocolObject.whiteCardModels);
    }
}
