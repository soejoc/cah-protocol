package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.BlackCardProtocolModel;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardProtocolModel;

import java.util.List;

public class AddCardsResponse extends ProtocolMessage {
    public BlackCardProtocolModel blackCardProtocolModel;
    public List<WhiteCardProtocolModel> whiteCardProtocolModels;

    @Override
    public int getMessageId() {
        return MessageCode.ADD_CARDS_RS;
    }
}
