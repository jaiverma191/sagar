package com.sagar.producer.consumer;

import java.util.Vector;

public class ProducerConsumerDemo {

	private int a=0;
	public static void main(String[] args) {
		Vector<Integer> sQueue = new Vector<Integer>();
		int size = 4;
		Thread producerThread = new Thread(new ProducerThread(sQueue, size));
		producerThread.setName("Producer 1");
		Thread producerThread1 = new Thread(new ProducerThread(sQueue, size));
		producerThread1.setName("Producer 2");
		Thread consumerThread = new Thread(new ConsumerThread(sQueue));
		consumerThread.setName("Consumer 1");
		Thread consumerThread1 = new Thread(new ConsumerThread(sQueue));
		consumerThread1.setName("Consumer 2");
		producerThread.start();
		producerThread1.start();
		consumerThread.start();
		consumerThread1.start();

	}
	private class MEthai
	{
		public MEthai() {
			System.out.println(a);
		}
	}
}

class ProducerThread implements Runnable {
	private final Vector<Integer> sQueue;
	private final int SIZE;

	public ProducerThread(Vector<Integer> queue, int size) {
		this.SIZE = size;
		this.sQueue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+ " is trying to insert item " + i);
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		while (sQueue.size() == SIZE) {
			synchronized (sQueue) {
				System.out.println("Queue is Full " + Thread.currentThread().getName() + " waiting");
				sQueue.wait();
			}
		}

		// ---CRITICAL SECTION----
		synchronized (sQueue) {
			sQueue.add(i);
			sQueue.notifyAll();
		}
		// ---CRITICAL SECTION---
	}

}

class ConsumerThread implements Runnable {
	private final Vector<Integer> sQueue;

	public ConsumerThread(Vector<Integer> queue) {
		this.sQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " Consuming Element " + consume());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private Integer consume() throws InterruptedException {
		while (sQueue.isEmpty()) {
			synchronized (sQueue) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " waiting for new element");
				sQueue.wait();
			}
		}
		synchronized (sQueue) {
			sQueue.notifyAll();
			return sQueue.remove(0);
		}
	}

}