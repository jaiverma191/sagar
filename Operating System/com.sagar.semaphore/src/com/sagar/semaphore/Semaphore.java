package com.sagar.semaphore;

public class Semaphore {

	int value;

	public Semaphore(int intialValue) {
		this.value = intialValue;
	}

	public synchronized void p() {
		while (value <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}

		}
		value = value - 1;
	}

	public synchronized void v() {
		value = value + 1;
		this.notify();
	}

}
