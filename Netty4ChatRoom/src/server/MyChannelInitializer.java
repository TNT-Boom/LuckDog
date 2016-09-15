package server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import server.handler.TimeHandler;

public class MyChannelInitializer extends ChannelInitializer<Channel>
{

	@Override
	protected void initChannel(Channel ch)
		throws Exception
	{
		ch.pipeline().addLast(new TimeHandler());
		
	}
	
}
