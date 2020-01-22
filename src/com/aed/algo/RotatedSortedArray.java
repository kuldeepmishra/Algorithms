package com.aed.algo;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {100, 101, 105, 37, 38, 45, 50, 55};
        System.out.println(find(arr, 100));
        System.out.println(find(arr, 101));
        System.out.println(find(arr, 105));
        System.out.println(find(arr, 37));
        System.out.println(find(arr, 38));
        System.out.println(find(arr, 45));
        System.out.println(find(arr, 50));
        System.out.println(find(arr, 55));

        int[] arr2 = {100, 100, 100, 100, 100, 100, 50, 100};
        System.out.println(find(arr2, 50));
    }

    public static int find(int[] arr, int elem) {
        int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == elem) {
                return mid;
            }

            boolean lowerSorted = false;
            boolean upperSorted = false;

            if (arr[low] <= arr[mid]) {
                if(elem >= arr[low] && elem < arr[mid]) {
                    high = mid-1;
                    continue;
                }
                lowerSorted = true;
            } else if (arr[mid] <= arr[high]) {
                if (elem > arr[mid] && elem <= arr[high]) {
                    low = mid + 1;
                    continue;
                }
                upperSorted = true;
            }

            if (!lowerSorted) {
                high = mid - 1;
            }

            if (!upperSorted) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
