package com.sagar.thread.pool;

public class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Performing Task 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
