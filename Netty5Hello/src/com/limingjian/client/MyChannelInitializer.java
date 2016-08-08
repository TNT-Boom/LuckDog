package com.limingjian.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class MyChannelInitializer extends ChannelInitializer<Channel>
{

	@Override
	protected void initChannel(Channel ch)
		throws Exception
	{
		ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new ClientHandler());
		
	}
	
}
