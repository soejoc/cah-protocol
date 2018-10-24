package protocol.object.response;

import codec.decoder.DecoderBase;
import codec.decoder.StartGameRequestDecoder;
import codec.decoder.StartGameResponseDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.StartGameRequestEncoder;
import codec.encoder.StartGameResponseEncoder;
import protocol.MessageCode;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

public class StartGameResponse extends ProtocolObject {
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new StartGameResponseDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameResponseEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RS;
    }
}
