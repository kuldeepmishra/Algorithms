package com.amazon.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpdateServerList {

    public static void main(String[] args) {
        UpdateServerList updateServersList = new UpdateServerList();
        List<List<Integer>> grid = Arrays.asList(Arrays.asList(0,1,1,0,1), Arrays.asList(0,1,0,1,0), Arrays.asList(0,0,0,0,1), Arrays.asList(0,1,0,0,0));
        System.out.println("Minimum Days took to update = "+updateServersList.minimumDays(4, 5, grid));
    }

    public int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        printGrid(rows, columns, grid, 0);
        return minimumDays(rows, columns, grid, 1);
    }

    private int minimumDays(int rows, int columns, List<List<Integer>> grid, int days) {
        List<List<Integer>> newGrid = Stream.generate(() -> Stream.generate(() -> 0).limit(columns).collect(Collectors.toList())).limit(rows).collect(Collectors.toList());

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                if(grid.get(i).get(j) == 1) {
                    newGrid.get(i).set(j, 1);
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

    private boolean allUpdated(List<List<Integer>> grid) {
        return grid.stream().flatMap(Collection::stream).allMatch(n -> n == 1);
    }

    private void updateAdjacentServers(int i, int j, int rows, int columns, List<List<Integer>> grid) {
        if((i-1) >= 0) {
            grid.get(i-1).set(j, 1);
        }

        if((j-1) >= 0) {
            grid.get(i).set(j-1, 1);
        }

        if((i+1) < rows) {
            grid.get(i+1).set(j, 1);
        }

        if((j+1) < columns) {
            grid.get(i).set(j+1, 1);
        }
    }

    private void printGrid(int rows, int columns, List<List<Integer>> grid, int days) {
        System.out.println("Server Grid On Day : "+days);
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < columns ; j++) {
                System.out.print(grid.get(i).get(j)+"  ");
            }
            System.out.println();
        }
    }
}
