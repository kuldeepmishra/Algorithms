package com.aed.algo;

public class DiagonalMatrix {

    public static void main(String[] args) {
        char[][] mat = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'm', 'n', 'o', 'p'},
                {'q', 'r', 's', 't', 'u'}
        };
        printDiagonally(mat);
    }

    public static void printDiagonally(char[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        for (int k = 0; k < row; k++) {
            int i = k;
            int j = 0;
            while (i >= 0) {
                System.out.print(mat[i][j]+" -> ");
                i = i-1;
                j = j+1;
            }
            System.out.println();
        }

        for (int k = 1; k < col; k++) {
            int i = row - 1;
            int j = k;
            while (j < col) {
                System.out.print(mat[i][j]+" -> ");
                i = i - 1;
                j = j + 1;
            }
            System.out.println();
        }
    }
}
