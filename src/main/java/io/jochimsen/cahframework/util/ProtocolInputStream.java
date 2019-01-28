package io.jochimsen.cahframework.util;

import java.io.*;

public class ProtocolInputStream {
    private final ObjectInputStream objectInputStream;

    public ProtocolInputStream(final byte[] buf) throws IOException {
        final ByteArrayInputStream byteStream = new ByteArrayInputStream(buf);
        objectInputStream = new ObjectInputStream(byteStream);
    }

    public boolean readBoolean() throws IOException {
        return objectInputStream.readBoolean();
    }

    public char readCharacter() throws IOException {
        return objectInputStream.readChar();
    }

    public byte readByte() throws IOException {
        return objectInputStream.readByte();
    }

    public int readBytes(final byte[] b, final int off, final int len) throws IOException {
        return objectInputStream.read(b, off, len);
    }

    public short readShort() throws IOException {
        return objectInputStream.readShort();
    }

    public int readInt() throws IOException {
        return objectInputStream.readInt();
    }

    public long readLong() throws IOException {
       return objectInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return objectInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return objectInputStream.readDouble();
    }

    public String readString() throws IOException {
        return objectInputStream.readUTF();
    }

    @SuppressWarnings("unchecked")
    public <T> T readObject() throws IOException, ClassNotFoundException {
        return (T)objectInputStream.readObject();
    }
}
