package com.amazon.test;

import java.util.Arrays;

public class UpdateServersArray {

    public static void main(String[] args) {
        UpdateServersArray updateServersArray = new UpdateServersArray();
        int[][] grid =
        {
            {0,1,1,0,1},
            {0,1,0,1,0},
            {0,0,0,0,1},
            {0,1,0,0,0}
        };

        System.out.println("Minimum Days took to update = "+updateServersArray.minimumDays(4, 5, grid));
    }

    public int minimumDays(int rows, int columns, int[][] grid) {
        printGrid(rows, columns, grid, 0);
        return minimumDays(rows, columns, grid, 1);
    }

    private int minimumDays(int rows, int columns, int[][] grid, int days) {
        int[][] newGrid = new int[rows][columns];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                if(grid[i][j] == 1) {
                    newGrid[i][j] = 1;
                    updateAdjacentServers(i, j, rows, columns, newGrid);
                }
            }
        }

        printGrid(rows, columns, newGrid, days);

        if(allUpdated(newGrid)) {
            return days;
        } else {
            return minimumDays(rows, columns, newGrid, days+1);
        }
    }

    private boolean allUpdated(int[][] grid) {
        return Arrays.stream(grid).flatMapToInt(Arrays::stream).allMatch( n -> n == 1);
    }

    private void updateAdjacentServers(int i, int j, int rows, int columns, int[][] grid) {
        if((i-1) >= 0) {
            grid[i-1][j] = 1;
        }

        if((j-1) >= 0) {
            grid[i][j-1] = 1;
        }

        if((i+1) < rows) {
            grid[i+1][j] = 1;
        }

        if((j+1) < columns) {
            grid[i][j+1] = 1;
        }
    }

    private void printGrid(int rows, int columns, int[][] newGrid, int days) {
        System.out.println("Server Grid On Day : "+days);
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                System.out.print(newGrid[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
