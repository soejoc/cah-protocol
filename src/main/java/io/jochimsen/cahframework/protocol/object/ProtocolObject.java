package io.jochimsen.cahframework.protocol.object;

import io.jochimsen.cahframework.exception.EncodingException;
import io.jochimsen.cahframework.exception.ProtocolObjectInstantiationException;
import io.jochimsen.cahframework.protocol.error.error_message.InvalidMessageException;
import io.jochimsen.cahframework.util.ProtocolInputStream;
import io.jochimsen.cahframework.util.ProtocolOutputStream;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class ProtocolObject {
    /**
     * Creates an instance of a concrete protocol object subtype and inflates it with data from the specified stream.
     * For the purpose of instantiation of a protocol object via reflection, each concrete protocol object MUST have a default constructor.
     *
     * @param clazz Class of the protocol object to be created
     * @param protocolInputStream The stream used for deserialization
     * @return The instantiated protocol object
     * @throws ProtocolObjectInstantiationException Will be thrown if the protocol object could not be created
     */
    public static <T extends ProtocolObject> T fromProtocolInputStream(final Class<T> clazz, final ProtocolInputStream protocolInputStream) {
        try {
            final T protocolObject = clazz.getDeclaredConstructor().newInstance();

            if(protocolInputStream != null) {
                protocolObject.deserialize(protocolInputStream);
            }

            return protocolObject;
        } catch (final InstantiationException e) {
            throw new ProtocolObjectInstantiationException("Cannot instantiate an abstract class", e);
        } catch (final IllegalAccessException e) {
            throw new ProtocolObjectInstantiationException("Constructor is inaccessible", e);
        } catch (final NoSuchMethodException e) {
            throw new ProtocolObjectInstantiationException("Constructor could not be found", e);
        } catch (final InvocationTargetException e) {
            throw new ProtocolObjectInstantiationException("Constructor has thrown an exception", e);
        }
    }

    protected abstract DecoderBase<? extends ProtocolObject> getDecoder();
    protected abstract EncoderBase<? extends ProtocolObject> getEncoder();

    public boolean hasCodec() {
        return (getDecoder() != null && getEncoder() != null);
    }

    public void deserialize(final ProtocolInputStream protocolInputStream) {
        try {
            final DecoderBase<? extends ProtocolObject> decoder = getDecoder();

            if(decoder != null) {
                decoder.decode(protocolInputStream);
            }
        } catch (final IOException e) {
            throw new InvalidMessageException();
        }
    }

    public void serialize(final ProtocolOutputStream protocolOutputStream) {
        try {
            final EncoderBase<? extends ProtocolObject> encoder = getEncoder();

            if(encoder != null) {
                encoder.encode(protocolOutputStream);
            }
        } catch (final IOException e) {
            throw new EncodingException("Could not serialize protocol object", e);
        }
    }
}
