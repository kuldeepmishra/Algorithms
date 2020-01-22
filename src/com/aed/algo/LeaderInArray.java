package com.aed.algo;

public class LeaderInArray {

    public static void main(String[] args) {
        int[] arr = {15,16,3,2,6,1,4};
        leaderInArray(arr);
        leaderInArrayMFR(arr);
    }

    // O(n^2)
    public static void leaderInArray(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            for (j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    break;
                }
            }
            if(j == arr.length) {
                System.out.println(arr[i]+" is a Leader!");
            }
        }
    }

    public static void leaderInArrayMFR(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        System.out.println(max+" is a Leader!");

        for (int i = n-2; i >= 0; i--) {
            if(arr[i] > max) {
                max = arr[i];
                System.out.println(arr[i]+" is a Leader!");
            }
        }
    }
}
