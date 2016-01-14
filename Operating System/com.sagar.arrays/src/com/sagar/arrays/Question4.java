package com.sagar.arrays;

public class Question4 {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
		System.out.println("Smallest element " + smallestElement(arr, 0, arr.length - 1));
	}

	private static int smallestElement(int[] arr, int left, int right) {
		int mid = left + (right - left) / 2;
		if (arr[mid + 1] < arr[mid]) {
			return arr[mid + 1];
		}
		if (arr[mid - 1] > arr[mid]) {
			return arr[mid];
		}
		if (arr[mid] < arr[right])
			return smallestElement(arr, left, mid - 1);
		return smallestElement(arr, mid + 1, right);
	}
}
