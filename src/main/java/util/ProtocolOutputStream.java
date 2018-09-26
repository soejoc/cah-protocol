package util;

import protocol.Charset;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ProtocolOutputStream {
    // Only used as a wrapper to write to the actual output stream
    private final DataOutputStream dataOutputStream;
    private final ByteArrayOutputStream buffer;

    public ProtocolOutputStream() {
        buffer = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(buffer);
    }

    public ProtocolOutputStream(final int size) {
        buffer = new ByteArrayOutputStream(size);
        dataOutputStream = new DataOutputStream(buffer);
    }

    public ProtocolOutputStream write(final boolean val) throws IOException {
        dataOutputStream.writeBoolean(val);
        return this;
    }

    public ProtocolOutputStream write(final char val) throws IOException {
        dataOutputStream.writeChar(val);
        return this;
    }

    public ProtocolOutputStream write(final byte val) throws IOException {
        dataOutputStream.writeByte(val);
        return this;
    }

    public ProtocolOutputStream write(final byte[] b, final int off, final int len) throws IOException {
        dataOutputStream.write(b, off, len);
        return this;
    }

    public ProtocolOutputStream write(final short val) throws IOException {
        dataOutputStream.writeShort(val);
        return this;
    }

    public ProtocolOutputStream write(final int val) throws IOException {
        dataOutputStream.writeInt(val);
        return this;
    }

    public ProtocolOutputStream write(final long val) throws IOException {
        dataOutputStream.writeLong(val);
        return this;
    }

    public ProtocolOutputStream write(final float val) throws IOException {
        dataOutputStream.writeFloat(val);
        return this;
    }

    public ProtocolOutputStream write(final double val) throws IOException {
        dataOutputStream.writeDouble(val);
        return this;
    }

    public ProtocolOutputStream write(final String val) throws IOException {
        final byte[] stringAsByteArray = val.getBytes(Charset.defaultCharset);
        final int length = stringAsByteArray.length;

        write(length);
        return write(stringAsByteArray, 0, stringAsByteArray.length);
    }

    public ProtocolOutputStream write(final ProtocolOutputStream rhs) throws IOException {
        rhs.buffer.writeTo(buffer);
        return this;
    }

    public int size() {
        return buffer.size();
    }

    public void flush() throws IOException {
        buffer.flush();
    }

    public byte[] toByteArray() {
        return buffer.toByteArray();
    }
}
