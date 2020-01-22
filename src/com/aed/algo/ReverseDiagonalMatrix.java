package com.aed.algo;

public class ReverseDiagonalMatrix {

    public static void main(String[] args) {
        char[][] mat = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'}
        };
        printDiagonally(mat);
    }

    public static void printDiagonally(char[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        for (int k = 0; k < col - 1; k++) {
            int i = 0;
            int j = col-k-1;
            while (j < col) {
                System.out.print(mat[i][j]+" -> ");
                i = i+1;
                j = j+1;
            }
            System.out.println();
        }

        for (int k = 0; k < row; k++) {
            int i = k;
            int j = 0;
            while (i < row) {
                System.out.print(mat[i][j]+" -> ");
                i = i + 1;
                j = j + 1;
            }
            System.out.println();
        }
    }
}
