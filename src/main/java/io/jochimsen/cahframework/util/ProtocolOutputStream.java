package io.jochimsen.cahframework.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProtocolOutputStream {
    private final ByteArrayOutputStream buffer;
    private final ObjectOutputStream objectOutputStream;

    public ProtocolOutputStream() throws IOException {
        buffer = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(buffer);
    }

    public ProtocolOutputStream(final int size) throws IOException {
        buffer = new ByteArrayOutputStream(size);
        objectOutputStream = new ObjectOutputStream(buffer);
    }

    public ProtocolOutputStream write(final boolean val) throws IOException {
        objectOutputStream.writeBoolean(val);
        return this;
    }

    public ProtocolOutputStream write(final char val) throws IOException {
        objectOutputStream.writeChar(val);
        return this;
    }

    public ProtocolOutputStream write(final byte val) throws IOException {
        objectOutputStream.writeByte(val);
        return this;
    }

    public ProtocolOutputStream write(final byte[] b, final int off, final int len) throws IOException {
        objectOutputStream.write(b, off, len);
        return this;
    }

    public ProtocolOutputStream write(final short val) throws IOException {
        objectOutputStream.writeShort(val);
        return this;
    }

    public ProtocolOutputStream write(final int val) throws IOException {
        objectOutputStream.writeInt(val);
        return this;
    }

    public ProtocolOutputStream write(final long val) throws IOException {
        objectOutputStream.writeLong(val);
        return this;
    }

    public ProtocolOutputStream write(final float val) throws IOException {
        objectOutputStream.writeFloat(val);
        return this;
    }

    public ProtocolOutputStream write(final double val) throws IOException {
        objectOutputStream.writeDouble(val);
        return this;
    }

    public ProtocolOutputStream write(final String val) throws IOException {
        objectOutputStream.writeUTF(val);
        return this;
    }

    public <T extends Serializable> ProtocolOutputStream write(final T val) throws IOException {
        objectOutputStream.writeObject(val);
        return this;
    }

    public void flush() throws IOException {
        buffer.flush();
    }

    public byte[] getBuffer() {
        return buffer.toByteArray();
    }
}
