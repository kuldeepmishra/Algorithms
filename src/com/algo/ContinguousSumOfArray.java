package com.algo;

import java.util.PriorityQueue;

public class ContinguousSumOfArray {

	public static void main(String[] args) {

		int a[] = {20, 15, 14, -5, -6, -1};
		// int a[] = { -3, -1, 3, 4, -2, 5, -7, -10 };
		int n = a.length;
		int max_sum = maxSubArraySum(a, n);
		max_sum = maxSubArray(a, n);
		System.out.println("Maximum contiguous sum is " + max_sum);

		printMaxSubArray(a, n);

		System.out.println("kthLargestSum = "+kthLargestSum(a, n, 3));
	}

	private static int maxSubArraySum(int[] a, int n) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(curr_max + a[i], a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}

		return max_so_far;
	}

	private static int maxSubArray(int[] a, int n) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int i = 0; i < a.length; i++) {
			max_ending_here += a[i];

			if (max_ending_here < 0) {
				max_ending_here = 0;
			} else if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}

	private static int printMaxSubArray(int[] a, int n) {
		int max_so_far = 0;
		int max_ending_here = 0;
		int start = 0, end = 0, s = 0;

		for (int i = 0; i < a.length; i++) {
			max_ending_here += a[i];

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			} else if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

		}

		for (int i = start; i <= end; i++) {
			System.out.println(a[i]);
		}

		return max_so_far;
	}

	private static int kthLargestSum(int arr[], int n, int k) {
		// array to store predix sums
		int sum[] = new int[n + 1];
		sum[0] = 0;
		sum[1] = arr[0];
		for (int i = 2; i <= n; i++)
			sum[i] = sum[i - 1] + arr[i - 1];

		// priority_queue of min heap
		PriorityQueue<Integer> Q = new PriorityQueue<>();

		// loop to calculate the contigous subarray
		// sum position-wise
		for (int i = 1; i <= n; i++) {

			// loop to traverse all positions that
			// form contiguous subarray
			for (int j = i; j <= n; j++) {
				// calculates the contiguous subarray
				// sum from j to i index
				int x = sum[j] - sum[i - 1];

				// if queue has less then k elements,
				// then simply push it
				if (Q.size() < k)
					Q.add(x);

				else {
					// it the min heap has equal to
					// k elements then just check
					// if the largest kth element is
					// smaller than x then insert
					// else its of no use
					if (Q.peek() < x) {
						Q.poll();
						Q.add(x);
					}
				}
			}
		}

		// the top element will be then kth
		// largest element
		return Q.poll();
	}

}
