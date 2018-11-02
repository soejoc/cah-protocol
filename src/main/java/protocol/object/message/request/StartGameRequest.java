package protocol.object.message.request;

import codec.decoder.DecoderBase;
import codec.decoder.StartGameRequestDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.StartGameRequestEncoder;
import protocol.object.message.ProtocolMessage;
import protocol.object.message.MessageCode;
import protocol.object.ProtocolObject;
import protocol.object.model.PlayerModel;
import util.ProtocolInputStream;

import java.util.List;

public class StartGameRequest extends ProtocolMessage {
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new StartGameRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new StartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.START_GAME_RQ;
    }
}
