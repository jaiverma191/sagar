package com.sagar.custom.lock;

public class UseMyLock {
	
	public static void main(String[] args) {
		/*	Counter1 counter = new Counter1();
		
		IncThread incThread= new IncThread(counter);
		DecThread decThread= new DecThread(counter);
		incThread.start();
		decThread.start();*/
		
		ReenteredCode code = new ReenteredCode();
		code.enter();
		
	}

}