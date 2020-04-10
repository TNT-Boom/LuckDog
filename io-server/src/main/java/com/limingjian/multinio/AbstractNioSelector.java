package com.limingjian.multinio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

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
				processTaskQueue();
				select(selector);
				process(selector);
			}
			catch (Exception e)
			{
				
			}
		}
	}
	
	/*
	 * task������selectorע������¼�
	 */
	protected final void registerTask(Runnable task)
	{
		taskQueue.add(task);
		Selector selector = this.selector;
		
		if(selector != null)
		{
			if(wakenUp.compareAndSet(false, true)) // ���false,��Ϊtrue
			{
				/*
				 * ֮���Ե��ã�����Ϊ��Ӧ�ü�����channel�����˱仯����Ҫselectorһ�����¼��
				 */
				selector.wakeup(); // ��������ʹ�ü���������´ε��û���������
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
