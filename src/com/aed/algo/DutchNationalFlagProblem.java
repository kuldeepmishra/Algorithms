package com.aed.algo;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 0, 0, 1, 2, 1, 2, 0, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 : swap(arr, low, mid);
                         low++; mid++;
                         break;
                case 1 : mid++;
                         break;
                case 2 : swap(arr, mid, high);
                         high--;
                         break;
            }
        }
    }

    private static void swap(int[] arr, int mid, int high) {
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
    }
}
