package com.sagar.pattern.behavioral.chain.of.responisbility;

public class ConcreteHandlerTwo extends Handler {
	public boolean handleRequestImpl(Request request) {
		if (request.getValue() > 0) { // if request is eligible handle it
			System.out.println("Positive values are handled by ConcreteHandlerTwo:");
			System.out.println("\tConcreteHandlerTwo.HandleRequest : " + request.getDescription() + request.getValue());
			return true;
		} else {
			return false;
		}
	}
}
