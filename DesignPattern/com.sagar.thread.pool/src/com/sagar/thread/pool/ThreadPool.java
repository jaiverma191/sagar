package com.sagar.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> taskQueue = null;
	private Boolean isStoped = false;
	private List<PoolThread> threads = new ArrayList<PoolThread>();

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
		for (int i = 0; i < noOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for (PoolThread poolThread : threads) {
			poolThread.start();
		}
	}

	public synchronized void execute(Runnable task) {
		if (this.isStoped = false) {
			throw new IllegalStateException("ThreadPool is Stopped");
		}
		try {
			this.taskQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public synchronized void stop()
	{
		this.isStoped= true;
		for (PoolThread poolThread : threads) {
			poolThread.stopThread();
		}
	}
}
