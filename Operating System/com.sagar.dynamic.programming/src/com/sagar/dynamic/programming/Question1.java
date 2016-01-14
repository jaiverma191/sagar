package com.sagar.dynamic.programming;

public class Question1 {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 2 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			System.out.println("Not Possible");
		}

		Boolean[][] target = new Boolean[arr.length + 1][sum / 2 + 1];
		for (int i = 0; i <= arr.length; i++) {
			target[i][0] = Boolean.TRUE;
		}

		for (int i = 0; i <= sum / 2; i++) {
			target[0][i] = Boolean.FALSE;
		}

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				target[i][j] = target[i - 1][j];
				if (arr[i - 1] <= j) {
					target[i][j] = target[i][j] || target[i - 1][j - arr[i - 1]];
				}
			}
		}
		if (target[arr.length][sum / 2])
			System.out.println("Possible");
		else {
			System.out.println("Not Possible");
		}
	}
}
