package protocol.object.request;

import codec.decoder.DecoderBase;
import codec.decoder.StartGameRequestDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.StartGameRequestEncoder;
import protocol.Message;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

public class StartGameRequest extends ProtocolObject {
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(ProtocolInputStream protocolObjectStream) {
        return new StartGameRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return Message.START_GAME_RQ;
    }
}
