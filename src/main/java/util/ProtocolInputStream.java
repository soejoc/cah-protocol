package util;

import protocol.object.ProtocolObject;
import throwable.exception.BufferTooShortException;
import protocol.Charset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public UUID readUUID() throws IOException {
        final long mostSignificantBits = readLong();
        final long leastSignificantBits = readLong();

        return new UUID(mostSignificantBits, leastSignificantBits);
    }

    /**
     * Reads {@link ProtocolObject}s from the stream.
     * The provided class must be concrete and must have a nullary constructor.
     */
    public <T extends ProtocolObject> T readProtocolObject(final Class<T> clazz) {
        try {
            final T protocolObject = clazz.newInstance();
            protocolObject.fromStream(this);

            return protocolObject;
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("The specified class is an abstract class or interface");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("The specified class does not have a nullary constructor");
        }
    }

    /**
     * <p>
     *     This method reads a list of elements from the stream.
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
    public <T> List<T> readList(final Class<T> elementType) throws IOException {
        final int size = readInt();
        List<T> list;

        if(Boolean.TYPE == elementType) {
            final List<Integer> integerList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                integerList.add(readInt());
            }

            list = (List<T>)integerList;
        } else if(Character.TYPE == elementType) {
            final List<Character> characterList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                characterList.add(readCharacter());
            }

            list = (List<T>)characterList;
        } else if(Byte.TYPE == elementType) {
            final List<Byte> byteList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                byteList.add(readByte());
            }

            list = (List<T>)byteList;
        } else if(Short.TYPE == elementType) {
            final List<Short> shortList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                shortList.add(readShort());
            }

            list = (List<T>)shortList;
        } else if(Integer.TYPE == elementType) {
            final List<Integer> integerList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                integerList.add(readInt());
            }

            list = (List<T>)integerList;
        } else if(Long.TYPE == elementType) {
            final List<Long> longList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                longList.add(readLong());
            }

            list = (List<T>)longList;
        } else if(Float.TYPE == elementType) {
            final List<Float> floatList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                floatList.add(readFloat());
            }

            list = (List<T>)floatList;
        } else if(Double.TYPE == elementType) {
            final List<Double> doubleList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                doubleList.add(readDouble());
            }

            list = (List<T>)doubleList;
        } else if(String.class == elementType) {
            final List<String> stringList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                stringList.add(readString());
            }

            list = (List<T>)stringList;
        } else if(UUID.class == elementType) {
            final List<UUID> uuidList = new ArrayList<>();

            for(int i = 0; i < size; ++i) {
                uuidList.add(readUUID());
            }

            list = (List<T>)uuidList;
        } else if(ProtocolObject.class.isAssignableFrom(elementType)) {
            final List<ProtocolObject> protocolObjectList = new ArrayList<>();

            Class<? extends ProtocolObject> protocolObjectClass = (Class<? extends ProtocolObject>)elementType;

            for(int i = 0; i < size; ++i) {
                protocolObjectList.add(readProtocolObject(protocolObjectClass));
            }

            list = (List<T>)protocolObjectList;
        } else {
            throw new IllegalArgumentException("The specified element type is not supported");
        }

        return list;
    }

    public byte[] getBuffer() {
        return buffer;
    }
}
