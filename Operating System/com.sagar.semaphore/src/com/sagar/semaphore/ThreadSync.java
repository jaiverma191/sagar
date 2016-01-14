package com.sagar.semaphore;

public class ThreadSync {

	static Semaphore semaphore = new Semaphore(0);

	public static void main(String[] args) {
		// t1 should be executed before t2
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				semaphore.p();
				System.out.println("executing " + Thread.currentThread().getName());
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("executing " + Thread.currentThread().getName());
				semaphore.v();
			}
		});

		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t2.start();
		t1.start();

	}

}
