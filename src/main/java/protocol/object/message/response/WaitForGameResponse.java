package protocol.object.message.response;

import codec.decoder.DecoderBase;
import codec.encoder.EncoderBase;
import protocol.object.message.ProtocolMessage;
import protocol.object.message.MessageCode;
import protocol.object.ProtocolObject;
import util.ProtocolInputStream;

public class WaitForGameResponse extends ProtocolMessage {

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
