package io.jochimsen.cahframework.initializer;

import io.jochimsen.cahframework.handler.inbound.InboundMessageHandlerBase;
import io.jochimsen.cahframework.handler.inbound.SerializedProtocolMessageDecoder;
import io.jochimsen.cahframework.handler.outbound.SerializedProtocolMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ProtocolMessageChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final InboundMessageHandlerBase inboundMessageHandlerBase;

    public ProtocolMessageChannelInitializer(final InboundMessageHandlerBase inboundMessageHandlerBase) {
        this.inboundMessageHandlerBase = inboundMessageHandlerBase;
    }

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new SerializedProtocolMessageDecoder());
        channelPipeline.addLast(new SerializedProtocolMessageEncoder());
        channelPipeline.addLast(inboundMessageHandlerBase);
    }
}
