package com.limingjian.client;
/*
 * 多链接客户端
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MultiClient
{
	// 服务类
	private Bootstrap bootstrap = new Bootstrap();

	// 用来缓存Channel
	private List<Channel> channels = new ArrayList<>();
	
	/**
	 * 引用计数
	 */
	private final AtomicInteger index = new AtomicInteger();

	// 表示要创建多少条的会话
	public void init(int count)
	{
		// 只创建worker就可以
		EventLoopGroup worker = new NioEventLoopGroup();
		bootstrap.group(worker);

		bootstrap.channel(NioSocketChannel.class);

		bootstrap.handler(new MyChannelInitializer());

		for (int i = 1; i <= count; ++i)
		{
			ChannelFuture future = bootstrap.connect("127.0.0.1", 5555);
			channels.add(future.channel());
		}
	}
	
	public Channel nextChannel()
	{
		return getFirstActiveChannel(0);
	}
	
	private Channel getFirstActiveChannel(int count)
	{
		Channel channel = channels.get(Math.abs(index.getAndIncrement() % channels.size()));
		if(!channel.isActive()){
			//重连
			reconnect(channel);
			if(count >= channels.size()){
				throw new RuntimeException("no can use channel");
			}
			return getFirstActiveChannel(count + 1);
		}
		return channel;
	}
	
	private void reconnect(Channel channel)
	{
		synchronized(channel)
		{
			if(channels.indexOf(channel) == -1)
			{
				return;
			}
			
			Channel newChannel = bootstrap.connect("127.0.0.1",5555).channel();
			channels.set(channels.indexOf(channel), newChannel); // 本质，用新的channel替换
		}
	}
}
