package util;

import throwable.exception.BufferTooShortException;
import protocol.Charset;

import java.io.*;

public class ProtocolInputStream {
    // Only used as a wrapper to write to the actual output stream
    private final DataInputStream dataInputStream;
    private final ByteArrayInputStream byteStream;
    private final byte[] buffer;

    public ProtocolInputStream(final byte[] buf) {
        buffer = buf;
        byteStream = new ByteArrayInputStream(buf);
        dataInputStream = new DataInputStream(byteStream);
    }

    // WTF, I want C++ back; no fucking call-by-reference :(
    public boolean readBoolean() throws IOException {
        return dataInputStream.readBoolean();
    }

    public char readCharacter() throws IOException {
        return dataInputStream.readChar();
    }

    public byte readByte() throws IOException {
        return dataInputStream.readByte();
    }

    public int readBytes(final byte[] b, final int off, final int len) throws IOException {
        return dataInputStream.read(b, off, len);
    }

    public short readShort() throws IOException {
        return dataInputStream.readShort();
    }

    public int readInt() throws IOException {
        return dataInputStream.readInt();
    }

    public long readLong() throws IOException {
       return dataInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return dataInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return dataInputStream.readDouble();
    }

    public String readString() throws IOException {
        final int length = readInt();
        final byte[] stringAsBinary = new byte[length];

        if(readBytes(stringAsBinary, 0, length) != length) {
            throw new BufferTooShortException("Could not read the string from the input stream");
        }

        return new String(stringAsBinary, Charset.defaultCharset);
    }

    public byte[] getBuffer() {
        return buffer;
    }
}
