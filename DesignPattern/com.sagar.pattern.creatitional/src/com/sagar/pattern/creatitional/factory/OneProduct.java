package com.sagar.pattern.creatitional.factory;

public class OneProduct extends Product {

	static {
		ProductFactory.getInstance().registerProduct("ID1", new OneProduct());
	}

	public OneProduct createProduct() {
		return new OneProduct();
	}

	@Override
	public void printPrice() {
		System.out.println("price is 5$");
	}

}
