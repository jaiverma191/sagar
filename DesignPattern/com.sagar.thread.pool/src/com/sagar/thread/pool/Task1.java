package com.sagar.thread.pool;

public class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Performing Task 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}