package com.sagar.pattern.creatitional.singleton;

public class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new LazySingleton();
				}
			}
		}

		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
	
	public static void main(String[] args) {
		LazySingleton.getInstance().doSomething();
	}

}
