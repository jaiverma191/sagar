package com.sagar.pattern.creatitional.factory;

public class Main {
	
	static
	{
		try
		{
			Class.forName(OneProduct.class.getName());
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ProductFactory.getInstance().createProduct("ID1").printPrice();
	}

}