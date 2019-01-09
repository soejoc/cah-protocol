package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.request.SelectWinnerRequest;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class SelectWinnerRequestEncoder extends EncoderBase<SelectWinnerRequest> {
    public SelectWinnerRequestEncoder(final SelectWinnerRequest protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(WhiteCardModel.class, protocolObject.whiteCardModels);
    }
}
