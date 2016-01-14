package com.sagar.string;

public class Question3 {

	public static void main(String[] args) {
		char[] string = { 'A', 'B', 'C' };
		permute(string, 0, string.length - 1);
	}

	private static void permute(char[] string, int l, int r) {
		if (l == r) {
			System.out.println(string);
		}
		for (int i = l; i <= r; i++) {
			swap(string, l, i);
			permute(string, l + 1, r);
			swap(string, i, l);
		}
	}

	private static void swap(char[] string, int l, int i) {
		char temp = string[l];
		string[l] = string[i];
		string[i] = temp;
	}
}