package com.sagar.custom.lock;

public class Counter1 {

	private MyLock lock = new MyLock();
	private Integer count = 0;

	public Integer increment() {
		
		System.out.println("Acquiring lock: "+Thread.currentThread().getName());
		lock.lock();
		System.out.println("Got the lock: "+Thread.currentThread().getName());
		Integer newCount = count + 1;
		count++;
		System.out.println("Incrementing: "+Thread.currentThread().getName());
		lock.unLock();
		System.out.println("Releasing lock: "+Thread.currentThread().getName());
		return newCount;
	}

	public Integer decrement() {
		System.out.println("Acquiring lock: "+Thread.currentThread().getName());
		lock.lock();
		System.out.println("Got the lock: "+Thread.currentThread().getName());
		Integer newCount = count - 1;
		count--;
		System.out.println("Decrementing: "+Thread.currentThread().getName());
		lock.unLock();
		System.out.println("Releasing lock: "+Thread.currentThread().getName());
		return newCount;
	}
}
