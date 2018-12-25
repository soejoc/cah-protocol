package initializer;

import channel_handler.ProcessingHandler;
import codec.decoder.meta.MetaDecoder;
import codec.encoder.meta.MetaEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

public class SslClientInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;
    private final ProcessingHandler processingHandler;
    private final String host;
    private final int port;

    public SslClientInitializer(final SslContext sslCtx, final ProcessingHandler processingHandler, final String host, final int port) {
        this.sslCtx = sslCtx;
        this.processingHandler = processingHandler;
        this.host = host;
        this.port = port;
    }

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(sslCtx.newHandler(ch.alloc(), host, port));
        channelPipeline.addLast(new MetaDecoder());
        channelPipeline.addLast(new MetaEncoder());
        channelPipeline.addLast(processingHandler);
    }
}
