package io.jochimsen.cahframework.codec.encoder;

import io.jochimsen.cahframework.protocol.object.message.response.NewRoundResponse;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;

public class NewRoundResponseEncoder extends EncoderBase<NewRoundResponse> {
    public NewRoundResponseEncoder(final NewRoundResponse protocolObject) {
        super(protocolObject);
    }

    @Override
    protected void serialize(final ProtocolOutputStream stream) throws IOException {
        stream.write(protocolObject.blackCardModel);
        stream.write(WhiteCardModel.class, protocolObject.whiteCardModels);
    }
}
