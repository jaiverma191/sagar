package com.sagar.string;

public class Question2 {
	public static void main(String[] args) {
		char[] string = { 's', 'a', 'd', 'p', 'q', 'd', 's' };
		boolean[] bit = new boolean[256];
		int last = 0;
		for (int i = 0; i < string.length; i++) {
			int index = string[i];
			if (!bit[index]) {
				bit[index] = true;
				string[last] = string[i];
				last++;
			}
		}
		string[last] = '\0';
		System.out.println(string);

	}
}
