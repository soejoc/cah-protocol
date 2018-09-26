package protocol;

public final class Message {
    private Message() { }

    public static final int START_GAME_RQ = 0x00000001;
    public static final int START_GAME_RS = 0x00000002;
}
