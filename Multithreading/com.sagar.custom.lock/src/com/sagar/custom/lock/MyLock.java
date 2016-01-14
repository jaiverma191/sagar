package com.sagar.custom.lock;

public class MyLock {

	private Boolean isLocked = false;

	public synchronized void lock() {
		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isLocked = true;
	}

	public synchronized void unLock() {
		isLocked = false;
		notify();
	}
}