package io.jochimsen.cahframework.initializer;

import io.jochimsen.cahframework.handler.inbound.InboundHandlerBase;
import io.jochimsen.cahframework.handler.inbound.SerializedProtocolMessageDecoder;
import io.jochimsen.cahframework.handler.outbound.SerializedProtocolMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProtocolMessageChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final InboundHandlerBase inboundHandlerBase;

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new SerializedProtocolMessageDecoder());
        channelPipeline.addLast(new SerializedProtocolMessageEncoder());
        channelPipeline.addLast(inboundHandlerBase);
    }
}
