package com.practiceExamples.Array;

public class Array_27_MaxSumOfSubArray_Kadane {
    public static void main(String[] args) {
        System.out.println(maxSumOfSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
     * <p>  Kadane's Algorithm </p>
     * can be done using Sliding Window ?
     * This function finds the maximum sum of a contiguous subarray in nums using Kadane's Algorithm.
     * {-2, 1, -3, 4, -1, 2, 1, -5, 4}, output = 6 -> [4,-1,2,1]
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
