package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
import lombok.Value;

@Value
public class PlayerProtocolModel implements Serializable {
    private final UUID playerId;
    private final String nickName;
}
