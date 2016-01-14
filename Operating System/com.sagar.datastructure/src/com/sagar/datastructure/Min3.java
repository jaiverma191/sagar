package com.sagar.datastructure;

public class Min3 {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 10, 5, 6, 2, 30 };
		find3Numbers(arr);
	}

	private static void find3Numbers(int[] arr) {
		int max = arr.length - 1; // Index of maximum element from right side
		int min = 0; // Index of minimum element from left side
		int i;

		// Create an array that will store index of a smaller
		// element on left side. If there is no smaller element
		// on left side, then smaller[i] will be -1.
		int[] smaller = new int[arr.length];
		smaller[0] = -1; // first entry will always be -1
		for (i = 1; i < arr.length; i++) {
			if (arr[i] <= arr[min]) {
				min = i;
				smaller[i] = -1;
			} else
				smaller[i] = min;
		}

		// Create another array that will store index of a
		// greater element on right side. If there is no greater
		// element on right side, then greater[i] will be -1.
		int[] greater = new int[arr.length];
		greater[arr.length - 1] = -1; // last entry will always be -1
		for (i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= arr[max]) {
				max = i;
				greater[i] = -1;
			} else
				greater[i] = max;
		}

		// Now find a number which has both a greater number on
		// right side and smaller number on left side
		for (i = 0; i < arr.length; i++) {
			if (smaller[i] != -1 && greater[i] != -1) {
				System.out.println(arr[smaller[i]] + ":" + arr[i] + ":" + arr[greater[i]]);
				return;
			}
		}

		// If we reach number, then there are no such 3 numbers
		// printf("No such triplet found");

	}
}
