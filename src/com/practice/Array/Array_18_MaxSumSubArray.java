package com.practice.Array;


public class Array_18_MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSumOfDistinctSubArrays(new int[]{100, 200, 300, 400}, 2));
    }

    /**
     * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
     * Fixed-size Sliding Window with Additional Constraint (Distinct elements)
     */
    public static int maxSumOfDistinctSubArrays(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            throw new IllegalArgumentException("Subarray size K cannot be larger than the array size N");
        }

        // Compute the sum of the first window of size K
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        // Use this as the initial sum
        int windowSum = maxSum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k]; // Update the sum for the new window
            maxSum = Math.max(maxSum, windowSum); // Track the maximum sum
        }

        return maxSum;
    }

    /**
     * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
     * Variable-size Sliding Window or Two Pointers (with sum tracking)
     */
    public static int longestSubarrayWithSumK(int[] nums, int K) {
        int start = 0, end = 0; // two pointers
        int currentSum = 0;
        int maxLength = 0;

        // Traverse the array using the end pointer
        while (end < nums.length) {
            // Add the current element to the current sum
            currentSum += nums[end];

            // If the sum exceeds K, move the start pointer to reduce the window size
            while (currentSum > K && start <= end) {
                currentSum -= nums[start];
                start++;
            }

            // If we found a subarray with sum equals to K, update maxLength
            if (currentSum == K) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            // Move the end pointer to expand the window
            end++;
        }

        return maxLength;
    }
}
