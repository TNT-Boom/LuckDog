package com.limingjian.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client
{
	public static void main(String[] args)
	{
		
		Bootstrap bootstrap = new Bootstrap();
		
		// 只创建worker就可以
		EventLoopGroup worker = new NioEventLoopGroup();
		try
		{
			bootstrap.group(worker);
			
			bootstrap.channel(NioSocketChannel.class);
			
			bootstrap.handler(new MyChannelInitializer());
			
			ChannelFuture future = bootstrap.connect("127.0.0.1", 5555);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("Plaease input:....");
				String msg = bufferedReader.readLine();
				future.channel().writeAndFlush(msg);
			}
		}
		catch(Exception e)
		{
			
		}
		finally 
		{
			worker.shutdownGracefully();
		}
		
		
	}
}
