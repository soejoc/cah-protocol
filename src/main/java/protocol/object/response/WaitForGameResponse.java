package protocol.object.response;

import codec.decoder.DecoderBase;
import codec.decoder.StartGameResponseDecoder;
import codec.encoder.EncoderBase;
import codec.encoder.StartGameResponseEncoder;
import protocol.MessageCode;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

public class WaitForGameResponse extends ProtocolObject {

    @Override
    protected DecoderBase<? extends ProtocolObject> getDecoder(final ProtocolInputStream protocolObjectStream) {
        return null;
    }

    @Override
    protected EncoderBase<? extends ProtocolObject> getEncoder() {
        return null;
    }

    @Override
    public int getMessageId() {
        return MessageCode.WAIT_FOR_GAME_RS;
    }
}
