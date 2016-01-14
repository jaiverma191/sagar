package com.sagar.arrays;

public class Question8 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftRotate(arr, 2, 7);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	private static void leftRotate(int[] arr, int rotate, int size) {
		int max = gcd(rotate, size), j, k;
		for (int i = 0; i < max; i++) {
			int saveElement = arr[i];
			j = i;
			while (true) {
				k = j + rotate;
				if (k >= size)
					k = k - size;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = saveElement;

		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
