package io.jochimsen.cahframework.protocol.object.message;

public final class MessageCode {
    private MessageCode() { }

    // Special messages
    public static final int ERROR = 0xFFFFFFFF;

    // Standard messages
    public static final int START_GAME_RQ = 0x00000001;
    public static final int START_GAME_RS = 0x00000002;
    public static final int WAIT_FOR_GAME_RS = 0x00000003;
    public static final int RESTART_GAME_RQ = 0x00000004;
    public static final int FINISHED_GAME_RS = 0x00000005;
    public static final int ADD_CARDS_RS = 0x00000006;
    public static final int GAME_MASTER_RS = 0x00000007;
    public static final int SELECT_CARDS_RQ = 0x00000008;
}
