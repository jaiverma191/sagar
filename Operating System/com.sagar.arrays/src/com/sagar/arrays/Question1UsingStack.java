package com.sagar.arrays;

import java.util.Stack;

public class Question1UsingStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int[] s = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty()) {
				if (arr[i] > arr[stack.peek()]) {
					stack.pop();
					continue;
				}
				break;
			}
			Integer p;
			if (stack.empty())
				p = -1;
			else
				p = stack.peek();
			s[i] = i - p;
			stack.push(i);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length; i++) {
			if (max < s[i]) {
				max = s[i];
			}
		}
		System.out.println("Max=" + max);
	}
}
