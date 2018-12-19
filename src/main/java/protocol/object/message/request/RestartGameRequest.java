package protocol.object.message.request;

import codec.decoder.DecoderBase;
import codec.decoder.RestartGameRequestDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.RestartGameRequestEncoder;
import protocol.object.ProtocolObject;
import protocol.object.message.MessageCode;
import protocol.object.message.ProtocolMessage;
import util.ProtocolInputStream;

import java.util.UUID;

public class RestartGameRequest extends ProtocolMessage {
    public UUID sessionKey;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new RestartGameRequestDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new RestartGameRequestEncoder(this);
    }

    @Override
    public int getMessageId() {
        return MessageCode.RESTART_GAME_RQ;
    }
}
