package com.sagar.arrays;

public class Question9 {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 3, 2, 5 };
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			arr[i] = arr[i] - 1;
		}
		for (int i = 0; i < length; i++) {
			arr[arr[i] % length] = arr[arr[i] % length] + length;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+1+ ":" + arr[i] / length);
		}
	}
}
