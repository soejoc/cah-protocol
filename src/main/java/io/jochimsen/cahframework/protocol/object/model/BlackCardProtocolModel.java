package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;

import lombok.Data;
import lombok.Value;

@Value
public class BlackCardProtocolModel implements Serializable {
    private final long blackCardId;
}
