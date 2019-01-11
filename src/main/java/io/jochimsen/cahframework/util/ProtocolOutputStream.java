package io.jochimsen.cahframework.util;

import io.jochimsen.cahframework.protocol.Charset;
import io.jochimsen.cahframework.protocol.object.ProtocolObject;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

public class ProtocolOutputStream implements ProtocolStream {
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

    public ProtocolOutputStream write(final UUID val) throws IOException {
        write(val.getMostSignificantBits());
        return write(val.getLeastSignificantBits());
    }

    public ProtocolOutputStream write(final ProtocolObject val) throws IOException {
        val.serialize(this);
        return this;
    }

    public ProtocolOutputStream write(final ProtocolOutputStream rhs) throws IOException {
        rhs.buffer.writeTo(buffer);
        return this;
    }

    /**
     * <p>
     *     This method writes a collection of elements to the stream.
     * </p>
     * <p>
     *     The following element types are supported:
     *     <ul>
     *         <li>Boolean</li>
     *         <li>Character</li>
     *         <li>Byte</li>
     *         <li>Short</li>
     *         <li>Integer</li>
     *         <li>Long</li>
     *         <li>Float</li>
     *         <li>Double</li>
     *         <li>String</li>
     *         <li>UUID</li>
     *         <li>? extends ProtocolObject</li>
     *     </ul>
     * </p>
     *
     * @throws IllegalArgumentException Will be thrown if an unsupported element type was specified
     */
    @SuppressWarnings("unchecked")
    public <T> ProtocolOutputStream write(final Class<T> elementType, final Collection<T> collection) throws IOException {
        write(collection.size());

        if(Boolean.TYPE == elementType) {
            final Collection<Boolean> collectionOfBooleans = (Collection<Boolean>)collection;

            for (final Boolean val : collectionOfBooleans) {
                write(val);
            }
        } else if(Character.TYPE == elementType) {
            final Collection<Character> collectionOfCharacters = (Collection<Character>)collection;

            for (final Character val : collectionOfCharacters) {
                write(val);
            }
        } else if(Byte.TYPE == elementType) {
            final Collection<Byte> collectionOfBytes = (Collection<Byte>) collection;

            for (final Byte val : collectionOfBytes) {
                write(val);
            }
        } else if(Short.TYPE == elementType) {
            final Collection<Short> collectionOfShorts = (Collection<Short>) collection;

            for (final Short val : collectionOfShorts) {
                write(val);
            }
        } else if(Integer.TYPE == elementType) {
            final Collection<Integer> collectionOfIntegers = (Collection<Integer>) collection;

            for (final Integer val : collectionOfIntegers) {
                write(val);
            }
        } else if(Long.TYPE == elementType) {
            final Collection<Long> collectionOfLongs = (Collection<Long>) collection;

            for (final Long val : collectionOfLongs) {
                write(val);
            }
        } else if(Float.TYPE == elementType) {
            final Collection<Float> collectionOfFloats = (Collection<Float>) collection;

            for (final Float val : collectionOfFloats) {
                write(val);
            }
        } else if(Double.TYPE == elementType) {
            final Collection<Double> collectionOfDoubles = (Collection<Double>) collection;

            for (final Double val : collectionOfDoubles) {
                write(val);
            }
        } else if(String.class == elementType) {
            final Collection<String> collectionOfStrings = (Collection<String>) collection;

            for (final String val : collectionOfStrings) {
                write(val);
            }
        } else if(UUID.class == elementType) {
            final Collection<UUID> collectionOfUUIDs = (Collection<UUID>) collection;

            for (final UUID val : collectionOfUUIDs) {
                write(val);
            }
        } else if(ProtocolObject.class.isAssignableFrom(elementType)) {
            final Collection<ProtocolObject> collectionOfProtocolObjects = (Collection<ProtocolObject>) collection;

            for (final ProtocolObject val : collectionOfProtocolObjects) {
                write(val);
            }
        } else {
            throw new IllegalArgumentException("The element type of the collection is not supported");
        }

        return this;
    }

    public int size() {
        return buffer.size();
    }

    public void flush() throws IOException {
        buffer.flush();
    }

    @Override
    public byte[] getBuffer() {
        return buffer.toByteArray();
    }
}
