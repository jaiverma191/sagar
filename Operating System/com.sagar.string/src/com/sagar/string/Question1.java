package com.sagar.string;

public class Question1 {

	public static void main(String[] args) {
		String string = "7878979";
		int maxSize = 0;
		for (int i = 0; i < string.length() - 1; i++) {
			int l = i;
			int r = i + 1;
			int lSum = 0, rSum = 0;
			while (l >= 0 && r < string.length()) {
				lSum += string.charAt(l) - '0';
				rSum += string.charAt(r) - '0';
				System.out.println(""+lSum+" "+rSum);
				if (lSum == rSum) {
					if (maxSize < r-l+1) {
						maxSize = r-l+1;
					}
				}
				l--;
				r++;
			}

		}
		System.out.println(maxSize);
	}
}
