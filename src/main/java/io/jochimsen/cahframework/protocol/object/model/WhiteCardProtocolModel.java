package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;

public class WhiteCardProtocolModel implements Serializable {
    private final long whiteCardsId;

    public WhiteCardProtocolModel(final long whiteCardsId) {
        this.whiteCardsId = whiteCardsId;
    }

    public long getWhiteCardsId() {
        return whiteCardsId;
    }
}
