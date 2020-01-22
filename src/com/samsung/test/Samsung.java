package com.samsung.test;

import java.util.Arrays;

public class Samsung {

    public static void main(String[] args) {
        Samsung samsung = new Samsung();
        //int[] arr = {5,5,3,7,3,5};
        int[] arr = {3,3,5,7,5,3};
        System.out.println(Arrays.toString(arr));
        sort012(arr, 3,5,7);
        System.out.println(Arrays.toString(arr));
        //arr = samsung.sort(arr,3,5,7);
        //System.out.println(Arrays.toString(arr));
    }

    static void sort012(int a[], int x, int y, int z)
    {
        int min = Math.min(x, Math.min(y, z));
        int max = Math.max(x, Math.max(y, z));
        int middle = 5;
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            if(a[mid] == min) {
                temp = a[lo];
                a[lo] = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
            }
            else if(a[mid] == middle) {
                mid++;
            }
            else if(a[mid] == max) {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
            }
        }
    }


    public int[] sort(int[] arr, int x, int y, int z) {
        int min = Math.min(x, Math.min(y, z));
        int max = Math.max(x, Math.max(y, z));

        int minIndex = 0;
        int maxIndex = arr.length-1;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == min) {

                while(arr[minIndex] == min) {
                    minIndex++;
                }
                if(arr[minIndex] < arr[i]) {
                    swap(arr, minIndex, i);
                    i--;
                }
            } else if (arr[i] == max) {
                while(arr[maxIndex] == max && arr[maxIndex] < arr[i]) {
                    maxIndex--;
                }
                if(arr[maxIndex] > arr[i]) {
                    swap(arr, maxIndex, i);
                    i--;
                }
            }

        }
        return arr;
    }

    private void swap(int[] arr, int maxIndex, int i) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[i];
        arr[i] = temp;
    }
}
