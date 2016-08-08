package com.limingjian.multinio;

import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

import com.limingjian.multinio.pool.Boss;
import com.limingjian.multinio.pool.NioSelectorRunnablePool;

// 类似netty中的服务类
public class NioServerBootstrap
{
	private NioSelectorRunnablePool selectorRunnablePool;
	
	public NioServerBootstrap(NioSelectorRunnablePool nioSelectorRunnablePool)
	{
		this.selectorRunnablePool = nioSelectorRunnablePool;
	}
	
	public void bind(final SocketAddress localAddress)
	{
		try
		{
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(localAddress);
			
			// 获取Boss线程
			Boss nextBoss = selectorRunnablePool.nextBoss();
			nextBoss.registerAcceptChannelTask(serverSocketChannel);
		}
		catch(Exception e)
		{}
	}
}
