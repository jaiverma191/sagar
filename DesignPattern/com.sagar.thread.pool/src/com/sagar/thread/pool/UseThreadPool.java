package com.sagar.thread.pool;

import java.util.Random;

public class UseThreadPool {
	public static void main(String[] args) {
		Task1 task1 = new Task1();
		Task2 task2 = new Task2();
		Task3 task3 = new Task3();
		Task4 task4 = new Task4();
		int count = 0;
		ThreadPool pool = new ThreadPool(2, 4);
		while (count < 50) {
			Random random = new Random();
			int n = random.nextInt(4);
			switch (n) {
			case 0:
				pool.execute(task1);
				break;
			case 1:
				pool.execute(task2);
				break;
			case 2:
				pool.execute(task3);
				break;
			case 3:
				pool.execute(task4);
				break;
			default:
				break;
			}
			count++;
		}
		pool.stop();
	}
}