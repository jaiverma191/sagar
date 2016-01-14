package com.sagar.thread.pool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {

	private BlockingQueue<Runnable> taskQueue = null;
	private Boolean isStoped = false;

	public PoolThread(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {
		while(!isStoped())
		{
			Runnable runnable;
			try {
				runnable = taskQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void stopThread() {
		isStoped = true;
	}
	
	public synchronized Boolean isStoped() {
		return isStoped ;
	}

}
