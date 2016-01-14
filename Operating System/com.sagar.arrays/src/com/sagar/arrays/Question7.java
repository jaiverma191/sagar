package com.sagar.arrays;

public class Question7 {

	public static void main(String[] args) {
		int[] arr = { 6, -3, -10, 0, 2};

		int maxProductSoFar = 1;
		int maxEndingHere = 1;
		int minEndingHere = 1;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {
				maxEndingHere *= arr[i];
				minEndingHere = min(minEndingHere * arr[i], 1);
			}
			if (arr[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				int temp = maxEndingHere;
				maxEndingHere = max(minEndingHere * arr[i], 1);
				minEndingHere = temp * arr[i];
			}
			if (maxProductSoFar < maxEndingHere) {
				maxProductSoFar = maxEndingHere;
			}
		}
		System.out.println("Maximum Product = " + maxProductSoFar);
	}

	private static int max(int i, int j) {
		if (i > j)
			return i;
		return j;
	}

	private static int min(int i, int j) {
		if (i < j)
			return i;
		return j;
	}
}
