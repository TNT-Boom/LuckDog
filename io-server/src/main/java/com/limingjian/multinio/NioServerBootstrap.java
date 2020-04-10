package com.limingjian.multinio;

import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;

import com.limingjian.multinio.pool.Boss;
import com.limingjian.multinio.pool.NioSelectorRunnablePool;

// ����netty�еķ�����
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
			
			// ��ȡBoss�߳�
			Boss nextBoss = selectorRunnablePool.nextBoss();
			nextBoss.registerAcceptChannelTask(serverSocketChannel);
		}
		catch(Exception e)
		{}
	}
}
