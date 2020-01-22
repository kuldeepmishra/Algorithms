package com.algo;

public class FindPaths {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                {4,8,2},
                {1,5,3}};
        System.out.println(findPaths(matrix));
    }

    public static int findPaths(int[][] matrix) {
        return findPaths(matrix, 0, 0);
    }

    private static int findPaths(int[][] matrix, int m, int n) {

        if(m == matrix.length || n == matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if(m == matrix.length-1 && n == matrix[0].length-1) {
            return matrix[m][n];
        }

        return matrix[m][n]+ Math.min(findPaths(matrix, m+1, n), findPaths(matrix, m, n+1));
    }

    private static int findPaths2(int[][] matrix, int m, int n) {

        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if(m == 0 && n == 0) {
            return matrix[m][n];
        }

        return matrix[m][n]+ Math.min(findPaths2(matrix, m-1, n), findPaths2(matrix, m, n-1));
    }
}
