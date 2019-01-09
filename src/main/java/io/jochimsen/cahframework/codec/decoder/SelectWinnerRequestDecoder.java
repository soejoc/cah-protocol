package io.jochimsen.cahframework.codec.decoder;

import io.jochimsen.cahframework.protocol.object.message.request.SelectWinnerRequest;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.io.IOException;

public class SelectWinnerRequestDecoder extends DecoderBase<SelectWinnerRequest> {
    public SelectWinnerRequestDecoder(final ProtocolInputStream rawMessage, final SelectWinnerRequest protocolObject) {
        super(rawMessage, protocolObject);
    }

    @Override
    public void decode() throws IOException {
        protocolObject.whiteCardModels = rawMessage.readList(WhiteCardModel.class);
    }
}
