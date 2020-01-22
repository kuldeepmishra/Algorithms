package com.codelity.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Codelity {

    public static void main(String[] args) {
        Codelity codelity = new Codelity();

        System.out.println(codelity.solution(new int[] {1, 3, 6, 4, 1, 2}));
        System.out.println(codelity.solution(new int[] {1, 2, 3}));
        System.out.println(codelity.solution(new int[] {-1, -3}));

        int A[] = { 0, 10, 2, -10, -20 };
        System.out.println(solution2(A));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                treeSet.add(A[i]);
            }
        }

        int smallestPositive = 1;
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            if(iterator.next() == smallestPositive) {
                smallestPositive += 1;
            } else {
                break;
            }
        }

        return smallestPositive;
    }

    public static int solution2(int[] A)
    { // Our original array

        int m = Arrays.stream(A).max().getAsInt(); // Storing maximum value
        if (m < 1) // In case all values in our array are negative
        {
            return 1;
        }
        if (A.length == 1) {

            // If it contains only one element
            if (A[0] == 1) {
                return 2;
            }
            else {
                return 1;
            }
        }
        int i = 0;
        int[] l = new int[m];
        for (i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (l[A[i] - 1] != 1) // Changing the value status at the index of our list
                {
                    l[A[i] - 1] = 1;
                }
            }
        }
        for (i = 0; i < l.length; i++) // Encountering first 0, i.e, the element with least value
        {
            if (l[i] == 0) {
                return i + 1;
            }
        }
        // In case all values are filled between 1 and m
        return i + 2;
    }

}
