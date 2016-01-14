package com.sagar.pattern.behavioral.chain.of.responisbility;

public abstract class Handler {

	protected Handler m_successor;

	public void setSuccessor(Handler successor) {
		m_successor = successor;
	}

	public abstract boolean handleRequestImpl(Request request);

	public final void handleRequest(Request request) {
		boolean handledByThisNode = this.handleRequestImpl(request);
		if (m_successor != null && !handledByThisNode) {
			m_successor.handleRequest(request);
		}
	}
}
