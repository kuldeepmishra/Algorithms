package com.algo;

public class RodCutting {

	static int cutRodRecursive(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++)
			max_val = Math.max(max_val, price[i] + cutRodRecursive(price, n - i - 1));

		return max_val;
	}

	/*
	 * Returns the best obtainable price for a rod of length n and price[] as prices
	 * of different pieces
	 */
	static int cutRod(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return
		// the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int arr[] = new int[] { 2, 5, 9, 6 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
		System.out.println("Maximum Obtainable Value is " + cutRodRecursive(arr, size));
	}
}
