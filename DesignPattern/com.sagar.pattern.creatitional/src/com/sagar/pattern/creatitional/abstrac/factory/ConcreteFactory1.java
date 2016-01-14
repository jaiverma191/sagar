package com.sagar.pattern.creatitional.abstrac.factory;

public class ConcreteFactory1 extends AbstractFactory {
	AbstractProductA createProductA() {
		return new ProductA1("ProductA1");
	}

	AbstractProductB createProductB() {
		return new ProductB1("ProductB1");
	}
}
