package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 * Fixed-size Sliding Window with Additional Constraint (Distinct elements)
 * This function finds the maximum sum of a subarray with exactly k elements, where all elements are distinct.
 * {1, 2, 3, 4, 5, 1, 2, 3}, k=3, Output=12 (3, 4, 5)
 */
public class Array_3_2_MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumOfDistinctSubArrays(new int[]{100, 200, 300, 400}, 2));
    }

    public static long maxSumOfDistinctSubArrays(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;
        int start = 0;

        for (int num = 0; num < nums.length; num++) {
            int currentNum = nums[num];

            // Add new element to the window
            countMap.put(currentNum, countMap.getOrDefault(currentNum, 0) + 1);
            currentSum += currentNum;

            // Check and adjust window if necessary
            while (countMap.get(currentNum) > 1) {
                int startNum = nums[start];
                countMap.put(startNum, countMap.get(startNum) - 1);
                currentSum -= startNum;
                start++;
            }

            // Update maxSum if we have a valid window of size k
            if (num - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Remove the element going out of the window
                int outgoingNum = nums[start];
                countMap.put(outgoingNum, countMap.get(outgoingNum) - 1);
                currentSum -= outgoingNum;
                start++;
            }
        }

        return maxSum;
    }


}
