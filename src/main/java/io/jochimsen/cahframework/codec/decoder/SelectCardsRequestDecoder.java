package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.request.SelectCardsRequest;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class SelectCardsRequestDecoder extends DecoderBase<SelectCardsRequest> {
    public SelectCardsRequestDecoder(final ProtocolInputStream rawMessage, final SelectCardsRequest protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.whiteCardModels = rawMessage.readList(WhiteCardModel.class);
    }
}
