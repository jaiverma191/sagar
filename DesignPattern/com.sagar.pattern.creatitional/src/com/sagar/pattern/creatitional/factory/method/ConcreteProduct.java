package com.sagar.pattern.creatitional.factory.method;

public class ConcreteProduct implements IProduct{

	@Override
	public void doWork() {
		System.out.println("Concrete Product");
	}

}