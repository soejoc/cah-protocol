package io.jochimsen.cahframework.protocol.object.model;

import io.jochimsen.cahframework.protocol.ProtocolObject;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = false)
public class PlayerProtocolModel extends ProtocolObject {
    private final UUID playerId;
    private final String nickName;
}
