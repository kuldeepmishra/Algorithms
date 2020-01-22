package com.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        Integer a[] = {1,4,5,7,8};
        Integer b[] = {2,6,8,10,13};
        Integer c[] = {7,8,9,14};

        int[] result = sort(Arrays.asList(a,b,c), 14);
        System.out.println(Arrays.toString(result));
    }

    static class Item {
        int arrNo;
        int arrIndex;
        int value;

        public Item(int arrNo, int arrIndex, int value) {
            this.arrNo = arrNo;
            this.arrIndex = arrIndex;
            this.value = value;
        }
    }

    public static int[] sort(List<Integer[]> listOfArrays, int n) {
        int[] result = new int[n];

        PriorityQueue<Item> minHeap = setUpHeap(listOfArrays);

        int index = 0;
        while(!minHeap.isEmpty()) {
            Item item = minHeap.remove();
            result[index++] = item.value;

            Integer arr[] = listOfArrays.get(item.arrNo);
            int arrIndex = item.arrIndex;
            if(arrIndex < arr.length-1) {
                arrIndex = arrIndex+1;
                minHeap.add(new Item(item.arrNo, arrIndex, arr[arrIndex]));
            }
        }

        return result;
    }

    private static PriorityQueue<Item> setUpHeap(List<Integer[]> listOfArrays) {
        PriorityQueue<Item> minHeap = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.value - o2.value;
            }
        });

        int i = 0;
        for (Integer[] arr: listOfArrays) {
            minHeap.add(new Item(i++, 0, arr[0]));
        }

        return minHeap;
    }
}
