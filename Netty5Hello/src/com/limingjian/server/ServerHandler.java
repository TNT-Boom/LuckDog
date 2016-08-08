package com.limingjian.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<String>
{

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
		throws Exception
	{
		System.out.println("Recv: " + msg);
		ctx.channel().write("i am server");
		
		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx)
	throws Exception
	{
		System.out.println("Channel active");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx)
	throws Exception
	{
		System.out.println("Channel Inactive");
	}

}
