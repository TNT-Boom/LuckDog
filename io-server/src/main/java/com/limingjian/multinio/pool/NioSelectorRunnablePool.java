package com.limingjian.multinio.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import com.limingjian.multinio.NioServerBoss;
import com.limingjian.multinio.NioServerWorker;

/*
 * 负责管理Boss们与Worker们
 */
public class NioSelectorRunnablePool
{
	// 里面会有多个线程，用于管理Selector
	private final AtomicInteger bossIndex = new AtomicInteger();
	private Boss[] bosses;
	
	private final AtomicInteger workerIndex = new AtomicInteger();
	private Worker[] workers;
	
	public NioSelectorRunnablePool(Executor boss, Executor worker)
	{
		 initBoss(boss, 1);
		 initWorker(worker, Runtime.getRuntime().availableProcessors() * 2);
	}
	
	private void initBoss(Executor boss, int count)
	{
		this.bosses = new Boss[count];
		for(int i = 0; i < count; i++)
		{
			bosses[i] = new NioServerBoss(boss, "boss thread " + i + 1, this);
		}
	}
	private void initWorker(Executor worker, int count)
	{
		this.workers = new NioServerWorker[count];
		for(int i = 0; i < count; ++i)
		{
			workers[i] = new NioServerWorker(worker, "worker thread " + i + 1, this);
		}
	}
	
	public Worker nextWorker()
	{
		return workers[Math.abs(workerIndex.getAndIncrement() % workers.length)];
	}
	
	public Boss nextBoss()
	{
		return bosses[Math.abs(bossIndex.getAndIncrement() % bosses.length)];
	}
}
