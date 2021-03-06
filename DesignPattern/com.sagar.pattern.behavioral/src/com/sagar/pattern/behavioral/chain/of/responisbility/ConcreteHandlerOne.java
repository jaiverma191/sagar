package com.sagar.pattern.behavioral.chain.of.responisbility;

public class ConcreteHandlerOne extends Handler {
	public boolean handleRequestImpl(Request request) {
		if (request.getValue() < 0) { // if request is eligible handle it
			System.out.println("Negative values are handled by ConcreteHandlerOne:");
			System.out.println("\tConcreteHandlerOne.HandleRequest : " + request.getDescription() + request.getValue());
			return true;
		} else {
			return false;
		}
	}
}
