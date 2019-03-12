package io.jochimsen.cahframework.protocol.object.message.response;

import io.jochimsen.cahframework.protocol.object.message.MessageCode;
import io.jochimsen.cahframework.protocol.object.message.ProtocolMessage;
import io.jochimsen.cahframework.protocol.object.message.ResponseMessage;
import io.jochimsen.cahframework.protocol.object.model.BlackCardProtocolModel;
import io.jochimsen.cahframework.protocol.object.model.WhiteCardProtocolModel;
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
