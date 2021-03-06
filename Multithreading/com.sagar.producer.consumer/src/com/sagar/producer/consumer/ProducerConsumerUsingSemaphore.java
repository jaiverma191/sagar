package com.sagar.producer.consumer;

import java.util.Vector;

public class ProducerConsumerUsingSemaphore {

	private static final int SIZE = 10;

	public static void main(String[] args) {

		Semaphore full = new Semaphore(0);
		Semaphore empty = new Semaphore(SIZE);
		Semaphore mutex = new Semaphore(1);
		Vector<Integer> sQueue = new Vector<Integer>();

		Thread producerThread = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 5000; i++) {
					empty.p();
					mutex.p();
					System.out.println(Thread.currentThread().getName() + " is trying to insert item " + i);
					sQueue.add(i);
					mutex.v();
					full.v();
				}
			}
		});

		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					full.p();
					mutex.p();
					System.out.println(Thread.currentThread().getName() + " Consuming Element " + sQueue.remove(0));
					mutex.v();
					empty.v();
				}
			}
		});

		producerThread.setName("Producer");
		consumerThread.setName("Consumer");

		consumerThread.start();
		producerThread.start();

	}

}
