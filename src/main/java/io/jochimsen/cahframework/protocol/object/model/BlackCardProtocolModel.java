package io.jochimsen.cahframework.protocol.object.model;

import lombok.Value;

import java.io.Serializable;

@Value
public class BlackCardProtocolModel implements Serializable {
    private final long blackCardId;
}
