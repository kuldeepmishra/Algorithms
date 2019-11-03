package com.algo;


import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		System.out.println(Arrays.toString(arr));

		sc.close();
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}

		int pivot = arr[(left+right)/2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while(left <= right) {
			while(arr[left] < pivot) {
				left++;
			}

			while(arr[right] > pivot) {
				right--;
			}

			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
