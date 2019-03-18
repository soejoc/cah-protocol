package io.jochimsen.cahprotocol.message.response;

import io.jochimsen.cahprotocol.message.MessageCode;
import io.jochimsen.cahprotocol.model.BlackCardProtocolModel;
import io.jochimsen.cahprotocol.model.WhiteCardProtocolModel;
import io.jochimsen.collo.protocol.ResponseMessage;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = false)
public class AddCardsResponse extends ResponseMessage {
    private final BlackCardProtocolModel blackCardProtocolModel;
    private final List<WhiteCardProtocolModel> whiteCardProtocolModels;

    @Override
    public int getMessageId() {
        return MessageCode.ADD_CARDS_RS;
    }
}
