package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.response.SelectCardResponse;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class SelectCardResponseDecoder extends DecoderBase<SelectCardResponse> {
    public SelectCardResponseDecoder(final ProtocolInputStream rawMessage, final SelectCardResponse protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.whiteCardModelList = rawMessage.readList(WhiteCardModel.class);
    }
}
