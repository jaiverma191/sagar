package com.sagar.arrays;

/**
 * Find max index difference j-i such that a[j]>a[i] and j>i.
 * 
 *
 */
public class Question1 {

	public static void main(String[] args) {
		int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int[] lMin = new int[arr.length];
		int[] rMax = new int[arr.length];

		int max = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
			}
			rMax[i] = max;
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < min) {
				min = arr[j];
			}
			lMin[j] = min;
		}

		int k = 0, l = 0, maxDiff = -1;
		while (k < arr.length && l < arr.length) {
			if (lMin[k] < rMax[l]) {
				if (l - k > maxDiff) {
					maxDiff = l - k;
				}
				l++;
			} else {
				k++;
			}
		}
		System.out.println(maxDiff);
	}
}
