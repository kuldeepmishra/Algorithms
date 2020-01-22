package com.aed.algo;

import java.util.Arrays;

public class RotationOfArray<T> {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));

        RotationOfArray<Integer> rotationOfArray = new RotationOfArray<>();
        rotationOfArray.rotate(arr, 2);

        Character[] characters = {'a','b','c','d','e','f','g'};
        System.out.println(Arrays.toString(characters));
        RotationOfArray<Character> rotationOfArray2 = new RotationOfArray<>();
        rotationOfArray2.rotate(characters, 2);
    }

    public void rotate(T[] arr, int r) {
        int n = arr.length-1;

        ReverseArray<T> reverseArray = new ReverseArray<>();
        reverseArray.reverse(arr, 0, n-r);
        System.out.println(Arrays.toString(arr));

        reverseArray.reverse(arr, n-r+1, n);
        System.out.println(Arrays.toString(arr));

        reverseArray.reverse(arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }
}
