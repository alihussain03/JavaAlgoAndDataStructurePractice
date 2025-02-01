package com.practiceExamples.Array;

public class Array_18_ArraySlidingWindow {
    public static void main(String[] args) {

        int[] Arr = {100, 200, 300, 400};
        int N = Arr.length, K = 2;

        long result = maximumSumSubarray(K, Arr, N);
        System.out.println(result);  // Output: 700
    }

    /**
     * https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
     */
    static long maximumSumSubarray(int k, int[] arr, int n) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
