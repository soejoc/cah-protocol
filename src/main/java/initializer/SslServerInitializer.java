package initializer;

import channel_handler.SslServerProcessingHandler;
import codec.decoder.meta.MetaDecoder;
import codec.encoder.meta.MetaEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class SslServerInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;
    private final SslServerProcessingHandler processingHandler;

    public SslServerInitializer(final SslContext sslCtx, final SslServerProcessingHandler processingHandler) {
        this.sslCtx = sslCtx;
        this.processingHandler = processingHandler;
    }

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(sslCtx.newHandler(ch.alloc()));
        channelPipeline.addLast(new MetaDecoder());
        channelPipeline.addLast(new MetaEncoder());
        channelPipeline.addLast(processingHandler);
    }
}
