package com.sagar.dynamic.programming;

public class Question5 {

	public static void main(String[] args) {
		char[] str1 = "sunday".toCharArray();
		char[] str2 = "monday".toCharArray();
		findMin(str1, str2);
	}

	private static void findMin(char[] str1, char[] str2) {
		int str2len = str2.length + 1;
		int str1len = str1.length + 1;
		int[][] table = new int[str1len][str2len];

		for (int i = 0; i < str1len; i++) {
			for (int j = 0; j < str2len; j++) {
				if (i == 0) {
					table[i][j] = j;
				} else if (j == 0) {
					table[i][j] = i;
				} else if (str1[i - 1] == str2[j - 1]) {
					table[i][j] = table[i - 1][j - 1];
				} else
					table[i][j] = 1 + min(table[i - 1][j], min(table[i - 1][j - 1], table[i][j - 1]));
			}
		}
		System.out.println(table[str1len - 1][str2len - 1]);
	}

	private static int min(int i, int j) {
		if (i < j)
			return i;
		return j;
	}
}