package com.sagar.deadlock;

public class Deadlock {

	public static void main(String[] args) {
		String r1 = "Resource1";
		String r2 = "Resource2";

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (r1) {
					System.out.println("Thread1 get lock : r1");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread1 trying to lock: r2");
					synchronized (r2) {
						
					}
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (r2) {
					System.out.println("Thread2 get lock : r2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread2 trying to lock: r1");
					synchronized (r1) {
						
					}
				}
			}
		});
		thread1.start();
		thread2.start();
		
		
	}

}
