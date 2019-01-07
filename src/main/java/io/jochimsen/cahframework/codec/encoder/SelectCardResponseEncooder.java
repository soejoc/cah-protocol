package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.response.SelectCardResponse;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class SelectCardResponseEncooder extends EncoderBase<SelectCardResponse> {
    public SelectCardResponseEncooder(final SelectCardResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(WhiteCardModel.class, protocolObject.whiteCardModelList);
    }
}
