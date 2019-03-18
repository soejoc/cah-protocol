package io.jochimsen.cahframework.message.response;

import io.jochimsen.cahframework.message.MessageCode;
import io.jochimsen.cahframework.model.BlackCardProtocolModel;
import io.jochimsen.cahframework.model.WhiteCardProtocolModel;
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
