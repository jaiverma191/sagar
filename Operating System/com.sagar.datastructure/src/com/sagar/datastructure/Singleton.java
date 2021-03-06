package com.sagar.datastructure;

public class Singleton {
	private static volatile Singleton singleton;

	private Singleton() {
		System.out.println("Singleton Object Created");
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
