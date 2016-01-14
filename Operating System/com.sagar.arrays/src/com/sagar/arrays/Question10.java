package com.sagar.arrays;

public class Question10 {

	public static void main(String[] args) {
		int arr2[] = { 1, 5, 7, 10, 13 };
		int arr1[] = { 11, 15, 23, 30, 45 };
		System.out.println(findMidian(arr1, arr2, 0, arr1.length - 1));
	}

	private static int findMidian(int[] arr1, int[] arr2, int left, int right) {
		int i = (left + right) / 2;

		int j = arr1.length - i - 1;
		if (left > right) {
			return findMidian(arr2, arr1, 0, arr1.length);
		}
		if (arr1[i] > arr2[j] && (j == arr1.length - 1 || arr1[i] < arr2[j + 1])) {
			if (i == 0 || arr2[j] > arr1[i - 1]) {
				return (arr1[i] + arr2[j]) / 2;
			} else {
				return (arr1[i] + arr1[i - 1]) / 2;
			}
		} else if (arr1[i] > arr2[j] && j != arr1.length - 1 && arr1[i] > arr2[j + 1]) {
			return findMidian(arr1, arr2, left, i - 1);
		} else {
			return findMidian(arr1, arr2, i + 1, right);
		}

	}

}
