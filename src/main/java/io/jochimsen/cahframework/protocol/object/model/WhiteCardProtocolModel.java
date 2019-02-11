package io.jochimsen.cahframework.protocol.object.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class WhiteCardProtocolModel implements Serializable {
    private final long whiteCardsId;
}
