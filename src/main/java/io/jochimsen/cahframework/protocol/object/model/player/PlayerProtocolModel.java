package io.jochimsen.cahframework.protocol.object.model.player;

import io.jochimsen.cahframework.protocol.object.DecoderBase;
import io.jochimsen.cahframework.protocol.object.EncoderBase;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;

import java.util.UUID;

public class PlayerProtocolModel extends ProtocolObject {
    public UUID playerId;
    public String nickName;

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder() {
        return new PlayerProtocolModelDecoder(this);
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return new PlayerProtocolModelEncoder(this);
    }
}
