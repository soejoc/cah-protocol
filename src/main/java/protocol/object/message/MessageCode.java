package protocol.object.message;

public final class MessageCode {
    private MessageCode() { }

    // Special messages
    public static final int ERROR = 0xFFFFFFFF;

    // Standard messages
    public static final int START_GAME_RQ = 0x00000001;
    public static final int START_GAME_RS = 0x00000002;
    public static final int WAIT_FOR_GAME_RS = 0x00000003;
}
