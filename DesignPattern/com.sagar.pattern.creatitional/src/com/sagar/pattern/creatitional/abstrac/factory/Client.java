package com.sagar.pattern.creatitional.abstrac.factory;

public class Client {
	public static void main(String args[]){
		AbstractFactory pf=FactoryMaker.getFactory("a");
		AbstractProductA product=pf.createProductA();
		//more function calls on product
		product.operationA1();
	}
}
