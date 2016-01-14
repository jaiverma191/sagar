package com.sagar.thread.pool;

public class Task4 implements Runnable {

	@Override
	public void run() {
		System.out.println("Performing Task 4");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
