package com.sagar.pattern.creatitional.singleton;

public class EarlySingleton {

	private static EarlySingleton instance = new EarlySingleton();

	private EarlySingleton() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static EarlySingleton getInstance() {
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}

	public static void main(String[] args) {
		EarlySingleton.getInstance().doSomething();
	}

}
