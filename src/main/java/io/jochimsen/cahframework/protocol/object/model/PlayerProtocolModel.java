package io.jochimsen.cahframework.protocol.object.model;

import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

@Value
public class PlayerProtocolModel implements Serializable {
    private final UUID playerId;
    private final String nickName;
}
