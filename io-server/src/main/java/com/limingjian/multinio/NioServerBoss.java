package com.limingjian.multinio;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import com.limingjian.multinio.pool.Boss;
import com.limingjian.multinio.pool.NioSelectorRunnablePool;
import com.limingjian.multinio.pool.Worker;

public class NioServerBoss extends AbstractNioSelector implements Boss
{

	public NioServerBoss(Executor boss, String threadName, NioSelectorRunnablePool pool)
	{
		super(boss, threadName, pool);
	}
	@Override
	public void registerAcceptChannelTask(final ServerSocketChannel serverChannel)
	{
		final Selector selector = this.selector; // �����selector
		registerTask(new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					serverChannel.register(selector, SelectionKey.OP_ACCEPT);
				}
				catch (ClosedChannelException e)
				{
					e.printStackTrace();
				}
				
			}
		});
		
	}
	@Override
	protected int select(Selector selector)
		throws IOException
	{
		return selector.select();
	}
	
	// ʵ��ִ���߼��Ĳ��֣���ʱ��Ӧ�̵߳�Selector�Ѿ�����
	@Override
	protected void process(Selector selector) 
		throws IOException
	{
		Set<SelectionKey> selectionKeys = selector.selectedKeys();
		if(selectionKeys.isEmpty())
		{
			return;
		}
		
		for(Iterator<SelectionKey> it = selectionKeys.iterator(); it.hasNext();)
		{
			SelectionKey key = it.next();
			it.remove(); // ��ֹ�ظ�����
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
			
			//��ȡ�ͻ�������
			SocketChannel clientChannel = serverSocketChannel.accept(); // ��ʱ�϶�������������Ϊ�ײ��Ѿ�����
			clientChannel.configureBlocking(false);
			
			Worker nextWorker = getNioSelectorRunnablePool().nextWorker();
			nextWorker.registerNewClientChannel(clientChannel);
			
			System.out.println("�յ��¿ͻ�������");
		}
		
	}

}
