package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.codec.decoder.NewRoundResponseDecoder;
import io.jochimsen.cahframework.codec.decoder.DecoderBase;
import io.jochimsen.cahframework.codec.encoder.NewRoundResponseEncoder;
import io.jochimsen.cahframework.codec.encoder.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;
import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.BlackCardModel;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardModel;
import io.jochimsen.cahframework.util.ProtocolInputStream;

import java.util.List;

public class NewRoundResponse extends ProtocolMessage {
    public BlackCardModel blackCardModel;
    public List<WhiteCardModel> whiteCardModels;

    @Override
    public int getMessageId() {
        return MessageCode.NEW_ROUND_RS;
    }

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new NewRoundResponseDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new NewRoundResponseEncoder(this);
    }
}
