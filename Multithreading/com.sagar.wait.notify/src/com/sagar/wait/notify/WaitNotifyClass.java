package com.sagar.wait.notify;

public class WaitNotifyClass {

	static int total = 0;

	public static void main(String[] args) {

		Thread adderThread = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 10000; i++) {
						total+=i;
					}
					this.notify();
				}

			}
		});

		adderThread.start();
		synchronized (adderThread) {
			try {
				adderThread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("total="+total);
	}

}
