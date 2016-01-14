package com.sagar.semaphore;

public class ReaderWriterProblem {

	private int readCount = 0;
	Semaphore wrt = new Semaphore(1);
	Semaphore mutex = new Semaphore(1);

	public static void main(String[] args) {
		ReaderWriterProblem problem= new ReaderWriterProblem();
		Thread writerThread = new Thread(problem.new WriterThread());
		Thread readerThread1 = new Thread(problem.new ReaderThread());
		Thread readerThread2 = new Thread(problem.new ReaderThread());
		readerThread1.start();
		readerThread2.start();
		writerThread.start();
	}

	class WriterThread implements Runnable {

		@Override
		public void run() {
			wrt.p();
			System.out.println("writing");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			wrt.v();
		}

	}

	class ReaderThread implements Runnable {

		@Override
		public void run() {
			mutex.p();
			readCount = readCount + 1;
			if (readCount == 1) {
				wrt.p();
			}
			mutex.v();
			System.out.println("Reading");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			mutex.p();
			readCount = readCount - 1;
			if (readCount == 0) {
				wrt.v();
			}
			mutex.v();
		}

	}

}
