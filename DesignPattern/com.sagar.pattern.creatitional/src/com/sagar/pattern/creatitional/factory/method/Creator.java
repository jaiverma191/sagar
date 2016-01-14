package com.sagar.pattern.creatitional.factory.method;

public abstract class Creator {
	public void anOperation() {
		IProduct product = factoryMethod();
		product.doWork();
	}

	protected abstract IProduct factoryMethod();

}
