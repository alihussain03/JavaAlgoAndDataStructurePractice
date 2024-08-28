package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */

public class Array_1_LeetCode_TwoSum {
    public static void main(String[] args) {
        System.out.println("");
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);

        for (int i : result) {
            System.out.println(i);
        }
        result = twoSumUsingHashMap(new int[]{2, 7, 11, 15}, 9);
        for (int i : result) {
            System.out.println(i);
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
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}