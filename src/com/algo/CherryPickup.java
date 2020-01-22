package com.algo;

import java.util.HashMap;
import java.util.Map;

public class CherryPickup {

    public static void main(String[] args) {
        int[][] grid = {{1,2,5},{3,2,1}};

        System.out.println(grid.length);
        System.out.println(grid[0].length);

        //System.out.println(cherryPickup(grid));
        //System.out.println(cherryPickupDP(grid, 3, 3));
    }

    public static int cherryPickup(int[][] grid) {
        return cherryPickup(grid, 0, 0);
    }

    private static int cherryPickup(int[][] grid, int m, int n) {
        if(m == grid.length || n == grid[0].length) {
            return 0;
        }
        int count = 0;
        if(grid[m][n] != -1) {
            count += grid[m][n] + cherryPickup(grid, m+1, n) + cherryPickup(grid, m, n+1);
            grid[m][n] = 0;
        }
        return count;
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int cherryPickupDP(int[][] grid, int row, int col) {
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 0; i < col; i++) {
            dp[i][0] = grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                if(grid[i][j] == -1) {
                    dp[i][j] = grid[i][j];
                } else {
                    int count = 0;
                    if(dp[i][j-1] != -1) {
                        count += dp[i][j-1];
                    }

                    if(dp[i-1][j] != -1) {
                        count += dp[i-1][j];
                    }

                    dp[i][j] =  count + grid[i][j];
                }
            }
        }

        return dp[row-1][col-1];
    }
}
