package com.sagar.deadlock;

public class DeadlockEasy {

	public static void main(String[] args) {
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
