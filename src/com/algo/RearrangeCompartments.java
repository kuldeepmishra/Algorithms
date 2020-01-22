package com.algo;

import java.util.Arrays;

public class RearrangeCompartments {

    public static void main(String[] args) {
        String[] compartments = {"P1", "P2", "P3", "L4", "P5", "P6", "P7", "L8", "P9", "P10", "E"};
        System.out.println(Arrays.toString(compartments));
        String [] result = rearrangeCompartments(compartments, 4);
        System.out.println(Arrays.toString(result));
    }

    public static String[] rearrangeCompartments(String[] compartments, int n) {
        String[] result = new String[compartments.length];

        int start = 0;
        int end = n;
        int index = 0;

        result[compartments.length-1] = "E";

        while(end <= compartments.length) {

            for (int i = end-1; i >= start; i--) {
                if(compartments[i].equals("E")) {
                    continue;
                }
                result[index++] = compartments[i];
            }

            start = end;
            end = end*2;
        }

        if(index < compartments.length) {
            for (int i = compartments.length - 2; i >= start; i--) {
                result[index++] = compartments[i];
            }
        }

        return result;
    }
}
