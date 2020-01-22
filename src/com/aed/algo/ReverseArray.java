package com.aed.algo;

import java.util.Arrays;

public class ReverseArray<T> {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        ReverseArray<Integer> reverseArray = new ReverseArray<Integer>();
        reverseArray.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reverse(T[] arr) {
        reverse(arr, 0, arr.length-1);
    }

    public void reverse(T[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        swap(arr, start, end);
        reverse(arr, start+1, end-1);
    }

    public void swap(T[] arr, int start, int end) {
        T temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
