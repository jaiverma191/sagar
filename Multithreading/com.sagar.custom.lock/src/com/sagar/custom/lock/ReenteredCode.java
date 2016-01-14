package com.sagar.custom.lock;

public class ReenteredCode {
	MyRLock lock;

	public ReenteredCode() {
		this.lock = new MyRLock();
	}

	public void enter() {
		System.out.println("Inside enter :Acquiring lock: " + Thread.currentThread().getName());
		lock.lock();
		System.out.println("Inside enter :Got the lock: " + Thread.currentThread().getName());
		reenter();
		lock.unLock();
		System.out.println("Inside enter :Releasing lock: " + Thread.currentThread().getName());
	}

	public void reenter() {
		System.out.println("Inside reenter :Acquiring lock: " + Thread.currentThread().getName());
		lock.lock();
		System.out.println("Inside reenter :Got the lock: " + Thread.currentThread().getName());
		lock.unLock();
		System.out.println("Inside reenter :Releasing lock: " + Thread.currentThread().getName());

	}
}