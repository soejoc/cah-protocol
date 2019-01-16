package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;

public class BlackCardProtocolModel implements Serializable {
    private final long blackCardId;

    public BlackCardProtocolModel(final long blackCardId) {
        this.blackCardId = blackCardId;
    }

    public long getBlackCardId() {
        return blackCardId;
    }
}
