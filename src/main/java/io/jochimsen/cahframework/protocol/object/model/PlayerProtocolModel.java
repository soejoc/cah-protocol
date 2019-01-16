package io.jochimsen.cahframework.protocol.object.model;

import java.io.Serializable;
import java.util.UUID;

public class PlayerProtocolModel implements Serializable {
    private final UUID playerId;
    private final String nickName;

    public PlayerProtocolModel(final UUID playerId, final String nickName) {
        this.playerId = playerId;
        this.nickName = nickName;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public String getNickName() {
        return nickName;
    }
}
