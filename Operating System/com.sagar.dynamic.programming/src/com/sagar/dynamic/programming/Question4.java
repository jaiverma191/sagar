package com.sagar.dynamic.programming;

public class Question4 {

	public static void main(String[] args) {
		char[] string1 = { 'A', 'G', 'G', 'T', 'A', 'B' };
		char[] string2 = { 'G', 'X', 'T', 'X', 'A', 'Y', 'B' };
		System.out.println("Lcs is : " + lcs(string1, string2));
	}

	private static String lcs(char[] string1, char[] string2) {
		int[][] table = new int[string1.length + 1][string2.length + 1];
		for (int i = 0; i <= string1.length; i++) {
			for (int j = 0; j <= string2.length; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (string1[i - 1] == string2[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		int index = table[string1.length][string2.length];
		char[] common = new char[index];
		common[index] = '\0';
		int i = string1.length;
		int j = string2.length;
		while (i > 0 && j > 0) {
			if (string1[i - 1] == string2[j - 1]) {
				index--;
				common[index] = string1[i - 1];
				i--;
				j--;
			} else if (table[i][j - 1] > table[i - 1][j]) {
				j--;
			} else {
				i--;
			}

		}

		return new String(common);

	}

	private static int max(int i, int j) {
		if (i > j)
			return i;
		return j;
	}
}
