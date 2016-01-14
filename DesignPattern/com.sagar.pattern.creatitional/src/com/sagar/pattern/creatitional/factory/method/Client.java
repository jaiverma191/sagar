package com.sagar.pattern.creatitional.factory.method;

public class Client {
	
	public static void main( String arg[] ) 
	{
		Creator creator = new ConcreteCreator();
		creator.anOperation();
	}

}
