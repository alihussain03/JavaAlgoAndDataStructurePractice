package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

public class Array_3_2_MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumOfDistinctSubArrays(new int[]{100, 200, 300, 400}, 2));
        System.out.println(maxSumOfSubarray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
     * Fixed-size Sliding Window with Additional Constraint (Distinct elements)
     * This function finds the maximum sum of a subarray with exactly k elements, where all elements are distinct.
     * {1, 2, 3, 4, 5, 1, 2, 3}, k=3, Output=12 (3, 4, 5)
     */
    public static long maxSumOfDistinctSubArrays(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        long maxSum = 0;
        long currentSum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            int num = nums[end];

            // Add new element to the window
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            currentSum += num;

            // Check and adjust window if necessary
            while (countMap.get(num) > 1) {
                int startNum = nums[start];
                countMap.put(startNum, countMap.get(startNum) - 1);
                currentSum -= startNum;
                start++;
            }

            // Update maxSum if we have a valid window of size k
            if (end - start + 1 == k) {
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

    /**
     * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
     * <p>  Kadane's Algorithm </p>
     * can be done using Sliding Window ?
     * This function finds the maximum sum of a contiguous subarray in nums using Kadane's Algorithm.
     * {-2, 1, -3, 4, -1, 2, 1, -5, 4}, output = 6
     */
    public static int maxSumOfSubarray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for (int num : nums) {
            // Step 1
            sum = sum + num;
            // Step 2
            maxSum = Math.max(maxSum, sum);
            // Step 3
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

}
