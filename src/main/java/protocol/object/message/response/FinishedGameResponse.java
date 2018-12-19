package protocol.object.message.response;

import codec.decoder.DecoderBase;
import codec.encoder.EncoderBase;
import protocol.object.ProtocolObject;
import protocol.object.message.MessageCode;
import protocol.object.message.ProtocolMessage;
import util.ProtocolInputStream;

public class FinishedGameResponse extends ProtocolMessage {

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
        return MessageCode.FINISHED_GAME_RS;
    }
}
