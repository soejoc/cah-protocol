package protocol.object.model;

import codec.decoder.DecoderBase;
import codec.decoder.PlayerDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.PlayerEncoder;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

import java.util.UUID;

public class PlayerModel extends ProtocolObject {
    public UUID playerId;
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return new PlayerDecoder(protocolObjectStream, this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new PlayerEncoder(this);
    }
}
