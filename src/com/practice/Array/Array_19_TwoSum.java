package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
public class Array_19_TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        result = twoSumUsingHashMap(new int[]{2, 7, 11, 15}, 9);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    // Brute force
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // using hashmap
    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
