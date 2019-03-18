package io.jochimsen.cahprotocol.model;

import io.jochimsen.collo.protocol.ProtocolObject;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = false)
public class PlayerProtocolModel extends ProtocolObject {
    private final UUID playerId;
    private final String nickName;
}
