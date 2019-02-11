package io.jochimsen.cahframework.handler.inbound;

import io.jochimsen.cahframework.util.ProtocolInputStream;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class RawProtocolMessageInput {
    private final int messageId;
    private final ProtocolInputStream protocolInputStream;
}
