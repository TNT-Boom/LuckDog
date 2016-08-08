package com.limingjian.multinio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jboss.netty.logging.Slf4JLoggerFactory;

import com.limingjian.multinio.pool.NioSelectorRunnablePool;

public abstract class AbstractNioSelector implements  Runnable
{
	/**
	 * �̳߳�
	 */
	private final Executor executor;
	
	/**
	 * ѡ����
	 */
	protected Selector selector;
	
	/*
	 * ���ѱ��
	 */
	protected final AtomicBoolean wakenUp = new AtomicBoolean();
	
	/*
	 * �������
	 */
	private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
	
	private String threadName;
	
	/*
	 * �̹߳������
	 */
	protected NioSelectorRunnablePool selectorRunnablePool;
	
	public AbstractNioSelector(Executor executor, String threadName, NioSelectorRunnablePool nioSelectorRunnablePool)
	{
		this.executor = executor;
		this.threadName = threadName;
		this.selectorRunnablePool = nioSelectorRunnablePool;
		openSelector();
	}
	
	private void openSelector()
	{
		try
		{
			this.selector = Selector.open();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.execute(this); // ��ִ���Լ���run
	}
	
	public void run()
	{
		Thread.currentThread().setName(threadName);
		while(true)
		{
			try
			{
				wakenUp.set(false);
				select(selector);
				
				processTaskQueue();
				
				process(selector);
			}
			catch (Exception e)
			{
				
			}
		}
	}
	
	protected final void registerTask(Runnable task)
	{
		Selector selector = this.selector;
		
		if(selector != null)
		{
			if(wakenUp.compareAndSet(false, true)) // ���false,��Ϊtrue
			{
				selector.wakeup();
			}
		}
		else
		{
			taskQueue.remove(task);
		}
	}
	
	private void processTaskQueue()
	{
		for(;;)
		{
			final Runnable task = taskQueue.poll();
			if(task == null)
				break;
			task.run();
		}
	}
	public NioSelectorRunnablePool getNioSelectorRunnablePool()
	{
		return selectorRunnablePool;
	}
	protected abstract int select(Selector selector) throws IOException; // ��������ģʽ�����������
	
	protected abstract void process(Selector selector) throws IOException;
}
