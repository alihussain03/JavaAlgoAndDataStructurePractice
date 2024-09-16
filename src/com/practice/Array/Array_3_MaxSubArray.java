package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

public class Array_3_MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumOfDistinctSubArrays(arr, 4));
        System.out.println(longestSubarrayWithSumK(arr, 2, arr.length));
        System.out.println(maxSumOfSubarray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
     * Fixed-size Sliding Window with Additional Constraint (Distinct elements)
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
     * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
     * Variable-size Sliding Window or Two Pointers (with sum tracking)
     */
    public static int longestSubarrayWithSumK(int[] arr, int sum, int n) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int curremtSum = 0;

        for (int i = 0; i < n; i++) {
            // Add current element to the prefix sum
            curremtSum += arr[i];

            // If the prefix sum is equal to sum, update maxLength
            if (curremtSum == sum) {
                maxLength = i + 1;
            }

            // If (curremtSum - sum) is found, update maxLength
            if (prefixSumMap.containsKey(curremtSum - sum)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(curremtSum - sum));
            }

            // Only store the first occurrence of the prefix sum
            if (!prefixSumMap.containsKey(curremtSum)) {
                prefixSumMap.put(curremtSum, i);
            }
        }

        return maxLength;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
     * <p>  Kadane's Algorithm </p>
     * can be done using Sliding Window ?
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
