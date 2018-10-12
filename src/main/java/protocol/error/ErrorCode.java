package protocol.error;

public final class ErrorCode {
    private ErrorCode() {}

    public static final int INVALID_PROTOCOL_VERSION = 0x00000001;
    public static final int INVALID_MESSAGE = 0x00000002;
}
