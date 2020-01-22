package com.aed.algo;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40, 50, 60},
                {15, 22, 32, 43, 56, 65},
                {17, 25, 33, 45, 57, 66},
                {21, 31, 34, 49, 59, 70}
        };
        search(mat, 31);
    }

    public static boolean search(int[][] mat, int value) {
        int i = 0;
        int j = mat[0].length - 1;

        while (i < mat[0].length && j >= 0) {
            if(value == mat[i][j]) {
                System.out.println(mat[i][j]);
                return true;
            } else if( value < mat[i][j]) {
                System.out.println(mat[i][j]);
                j--;
            } else {
                System.out.println(mat[i][j]);
                i++;
            }
        }
        return false;
    }
}
