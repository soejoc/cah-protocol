package io.jochimsen.cahprotocol.model;

import io.jochimsen.collo.protocol.ProtocolObject;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class BlackCardProtocolModel extends ProtocolObject {
    private final long blackCardId;
}
