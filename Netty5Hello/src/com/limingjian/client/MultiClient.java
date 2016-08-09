package com.limingjian.client;
/*
 * �����ӿͻ���
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
	// ������
	private Bootstrap bootstrap = new Bootstrap();

	// ��������Channel
	private List<Channel> channels = new ArrayList<>();
	
	/**
	 * ���ü���
	 */
	private final AtomicInteger index = new AtomicInteger();

	// ��ʾҪ�����������ĻỰ
	public void init(int count)
	{
		// ֻ����worker�Ϳ���
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
			//����
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
			channels.set(channels.indexOf(channel), newChannel); // ���ʣ����µ�channel�滻
		}
	}
}
