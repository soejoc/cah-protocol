package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.model.BlackCardProtocolModel;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardProtocolModel;

import java.util.List;

public class AddCardsResponse extends ProtocolMessage {
    private final BlackCardProtocolModel blackCardProtocolModel;
    private final List<WhiteCardProtocolModel> whiteCardProtocolModels;

    public AddCardsResponse(final BlackCardProtocolModel blackCardProtocolModel, final List<WhiteCardProtocolModel> whiteCardProtocolModels) {
        this.blackCardProtocolModel = blackCardProtocolModel;
        this.whiteCardProtocolModels = whiteCardProtocolModels;
    }

    public BlackCardProtocolModel getBlackCardProtocolModel() {
        return blackCardProtocolModel;
    }

    public List<WhiteCardProtocolModel> getWhiteCardProtocolModels() {
        return whiteCardProtocolModels;
    }

    @Override
    public int getMessageId() {
        return MessageCode.ADD_CARDS_RS;
    }
}
