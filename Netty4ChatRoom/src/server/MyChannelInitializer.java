package server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import server.handler.TimeDecoder;
import server.handler.TimeHandler;

public class MyChannelInitializer extends ChannelInitializer<Channel>
{
	@Override
	protected void initChannel(Channel ch)
		throws Exception
	{
		ch.pipeline().addLast(new TimeDecoder());
		ch.pipeline().addLast(new TimeHandler());
	}

}
