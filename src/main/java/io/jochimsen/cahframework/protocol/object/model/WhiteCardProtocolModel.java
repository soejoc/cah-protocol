package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;

import lombok.Value;

@Value
public class WhiteCardProtocolModel implements Serializable {
    private final long whiteCardsId;
}
