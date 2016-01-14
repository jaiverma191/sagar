package com.sagar.arrays;

public class Question3 {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 5, 1, 2 };
		int elementToSearch = 10;
		int checkElement = checkElement(arr, elementToSearch, 0, arr.length - 1);
		if (checkElement == -1) {
			System.err.println("element " + elementToSearch + " not present");
		} else {
			System.out.println("location of " + elementToSearch + " is " + checkElement+1);
		}
	}

	private static int checkElement(int[] arr, int elementToSearch, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (arr[mid] == elementToSearch)
			return mid;
		if (arr[left] < arr[mid]) {
			if (arr[mid] >= elementToSearch && elementToSearch >= arr[left]) {
				return checkElement(arr, elementToSearch, left, mid - 1);
			}
			return checkElement(arr, elementToSearch, mid + 1, right);
		}
		if (elementToSearch >= arr[mid] && elementToSearch <= arr[right]) {
			return checkElement(arr, elementToSearch, mid + 1, right);
		}
		return checkElement(arr, elementToSearch, left, mid - 1);
	}

}
