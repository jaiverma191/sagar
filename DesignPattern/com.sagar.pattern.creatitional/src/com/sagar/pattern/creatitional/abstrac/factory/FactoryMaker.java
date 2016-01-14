package com.sagar.pattern.creatitional.abstrac.factory;

public class FactoryMaker {
	private static AbstractFactory pf = null;

	static AbstractFactory getFactory(String choice) {
		if (choice.equals("a")) {
			pf = new ConcreteFactory1();
		} else if (choice.equals("b")) {
			pf = new ConcreteFactory2();
		}
		return pf;
	}
}
