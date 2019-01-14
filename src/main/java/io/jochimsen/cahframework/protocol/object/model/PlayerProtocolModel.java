package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;
import java.util.UUID;

public class PlayerProtocolModel implements Serializable {
    public UUID playerId;
    public String nickName;
}
