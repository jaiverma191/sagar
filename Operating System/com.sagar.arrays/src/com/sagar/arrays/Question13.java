package com.sagar.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question13 {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 6, 3, 1, 24, 7 };
		int window = 3;
		int[] result = new int[arr.length - window + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < window; i++) {
			while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		for (int i = window; i < arr.length; i++) {
			result[i - window] = arr[deque.getFirst()];
			while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
				deque.pollLast();
			}
			while (!deque.isEmpty() && deque.getFirst() <= i - window) {
				deque.pollFirst();
			}
			deque.addLast(i);
		}
		result[arr.length - window] = arr[deque.getFirst()];
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
