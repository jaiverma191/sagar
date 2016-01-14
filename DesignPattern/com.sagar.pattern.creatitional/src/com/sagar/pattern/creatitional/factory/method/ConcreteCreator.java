package com.sagar.pattern.creatitional.factory.method;

public class ConcreteCreator extends Creator{

	@Override
	protected IProduct factoryMethod() {
		return new ConcreteProduct();
	}

}
