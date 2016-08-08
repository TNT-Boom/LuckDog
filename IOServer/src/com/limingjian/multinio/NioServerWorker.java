package com.limingjian.multinio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import com.limingjian.multinio.pool.NioSelectorRunnablePool;
import com.limingjian.multinio.pool.Worker;

public class NioServerWorker extends AbstractNioSelector implements Worker
{

	public NioServerWorker(Executor executor, String threadName, NioSelectorRunnablePool nioSelectorRunnablePool)
	{
		super(executor, threadName, nioSelectorRunnablePool);
	}

	@Override
	public void registerNewClientChannel(final SocketChannel channel)
	{
		final Selector selector = this.selector;
		registerTask(new Runnable()
		{
			
			@Override
			public void run()
			{
				try
				{
					channel.register(selector, SelectionKey.OP_READ);
				}
				catch (ClosedChannelException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}

	@Override
	protected int select(Selector selector)
		throws IOException
	{
		return selector.select(500);
	}

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
			SelectionKey key= it.next();
			it.remove();
			SocketChannel channel = (SocketChannel)key.channel();
			
			// 可以读
			int ret = 0;
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			boolean failure = true;
			
			try
			{
				ret = channel.read(byteBuffer);
				failure = false;
			}
			catch(Exception e)
			{
				
			}
			
			if(ret <= 0 || failure)
			{
				key.cancel();
				System.out.println("Client disconnected, client:" + channel.getRemoteAddress());
			}
			else
			{
				System.out.println("Recv data:" + new String(byteBuffer.array()));
				
				ByteBuffer outBuffer = ByteBuffer.wrap("收到\n".getBytes());
	     		channel.write(outBuffer);// 将消息回送给客户端
			}
		}
	}

}
