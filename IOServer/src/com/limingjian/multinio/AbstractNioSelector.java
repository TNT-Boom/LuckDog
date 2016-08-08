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
	 * 线程池
	 */
	private final Executor executor;
	
	/**
	 * 选择器
	 */
	protected Selector selector;
	
	/*
	 * 唤醒标记
	 */
	protected final AtomicBoolean wakenUp = new AtomicBoolean();
	
	/*
	 * 任务队列
	 */
	private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
	
	private String threadName;
	
	/*
	 * 线程管理对象
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
		executor.execute(this); // 会执行自己的run
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
			if(wakenUp.compareAndSet(false, true)) // 如果false,置为true
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
	protected abstract int select(Selector selector) throws IOException; // 工厂方法模式，由子类决定
	
	protected abstract void process(Selector selector) throws IOException;
}
