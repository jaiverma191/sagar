package com.sagar.semaphore;

public class PrecedenceGraph {

	/*
	 * execute the following in order  s1 
	 * 							      /  \ 
	 * 								s2    s3 
	 * 								| 	  /
	 * 								s4   /  
	 * 								/ \ / 
	 * 							   s5 s6 
	 * 								\ / 
	 * 								 s7
	 */

	public static void main(String[] args) throws InterruptedException {
		Semaphore a = new Semaphore(0);
		Semaphore b = new Semaphore(0);
		Semaphore c = new Semaphore(0);
		Semaphore d = new Semaphore(0);
		Semaphore e = new Semaphore(0);
		Semaphore f = new Semaphore(0);
		Semaphore g = new Semaphore(0);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("executing " + Thread.currentThread().getName());
				a.v();
				b.v();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				a.p();
				System.out.println("executing " + Thread.currentThread().getName());
				c.v();
				d.v();
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				b.p();
				System.out.println("executing " + Thread.currentThread().getName());
				e.v();
			}
		});
		Thread t5 = new Thread(new Runnable() {

			@Override
			public void run() {
				c.p();
				System.out.println("executing " + Thread.currentThread().getName());
				f.v();
			}
		});
		Thread t6 = new Thread(new Runnable() {

			@Override
			public void run() {
				d.p();
				e.p();
				System.out.println("executing " + Thread.currentThread().getName());
				g.v();
			}
		});
		Thread t7 = new Thread(new Runnable() {

			@Override
			public void run() {
				f.p();
				g.p();
				System.out.println("executing " + Thread.currentThread().getName());

			}
		});

		t1.setName("Statement 1");
		t2.setName("Statement 2");
		t3.setName("Statement 3");
		t5.setName("Statement 5");
		t6.setName("Statement 6");
		t7.setName("Statement 7");
		
		t6.start();
		t7.start();
		t1.start();
		t2.start();
		t3.start();
		t5.start();
		

	}

}
