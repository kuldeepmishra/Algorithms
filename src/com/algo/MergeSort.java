package com.algo;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));

		sc.close();
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}

		int middle = (leftStart+rightEnd)/2;

		mergeSort(arr, temp, leftStart, middle);
		mergeSort(arr, temp, middle+1, rightEnd);
		mergeHalves(arr, temp, leftStart, rightEnd);
	}

	private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd+1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while(left <= leftEnd && right <= rightEnd) {

			if(arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}

		System.arraycopy(arr, left, temp, index, leftEnd-left+1);
		System.arraycopy(arr, right, temp, index, rightEnd-right+1);

		System.arraycopy(temp, leftStart, arr, leftStart, rightEnd-leftStart+1);
	}

}
