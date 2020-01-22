package com.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(-7*-7);

        int[] nums = {3,3};

        twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if(map.containsKey(remaining) && map.get(remaining) != i) {
                return new int[] {i, map.get(remaining)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
