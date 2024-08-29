package com.practice.Array.old;

/**
 * given an integer array nums and an integer k. Find the maximum subarray sum of all the
 * sub arrays of nums that meet the following conditions:
 * The length of the subarray is k, and All the elements of the subarray are distinct.
 * <p>
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */

// need to check one more time
public class Array_2_MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSumOfDistinctSubArrays(new int[]{100, 200, 300, 400}, 2));
    }

    public static int maxSumOfDistinctSubArrays(int[] Arr, int K) {
        int N = Arr.length;

        if (K > N) {
            throw new IllegalArgumentException("Subarray size K cannot be larger than the array size N");
        }

        // Compute the sum of the first window of size K
        int maxSum = 0;
        for (int i = 0; i < K; i++) {
            maxSum += Arr[i];
        }

        // Use this as the initial sum
        int windowSum = maxSum;

        // Slide the window across the array
        for (int i = K; i < N; i++) {
            windowSum += Arr[i] - Arr[i - K]; // Update the sum for the new window
            maxSum = Math.max(maxSum, windowSum); // Track the maximum sum
        }

        return maxSum;
    }
}
