package protocol.object.message.response;

import codec.decoder.DecoderBase;
import codec.decoder.StartGameResponseDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.StartGameResponseEncoder;
import protocol.object.model.PlayerModel;
import protocol.object.message.ProtocolMessage;
import protocol.object.message.MessageCode;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

import java.util.List;
import java.util.UUID;

public class StartGameResponse extends ProtocolMessage {
    public PlayerModel me;
    public List<PlayerModel> antagonists;
    public UUID sessionId;

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
