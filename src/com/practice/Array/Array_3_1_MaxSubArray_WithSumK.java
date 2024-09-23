package com.practice.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
 * Variable-size Sliding Window or Two Pointers (with sum tracking)
 * This function finds the longest subarray in arr where the total of its elements equals to the given sum.
 * {10, 5, 2, 7, 1, 9};  sum = 15; output = 4 -> { 5, 2, 7, 1}
 */

public class Array_3_1_MaxSubArray_WithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        System.out.println("Using Brute Force: " + longestSubarrayWithSumKUsingBruteForce(arr, 3, arr.length));
        System.out.println("Using Hashmap Force: " + getLongestSubarrayWithSumKUsingHashMap(arr, 3, arr.length));
        System.out.println("Using 2 Pointers: " + getLongestSubarrayWithSumKUsingTwoPointers(arr, 3, arr.length));
    }

    public static int longestSubarrayWithSumKUsingBruteForce(int[] arr, int k, int n) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static int getLongestSubarrayWithSumKUsingHashMap(int[] a, int k, int n) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        long currentSum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix currentSum till index i:
            currentSum += a[i];

            // if the currentSum = k, update the maxLen:
            if (currentSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the currentSum of remaining part i.e. x-k:
            long rem = currentSum - k;

            // This checks if the remainingSum (denoted as rem) has been encountered before
            if (prefixSumMap.containsKey(rem)) {
                int len = i - prefixSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }
        return maxLen;
    }


    public static int getLongestSubarrayWithSumKUsingTwoPointers(int[] arr, int k, int n) {
        int maxLength = 0, curremtSum = 0;
        int left = 0, right = 0;

        while (right < n) {
            curremtSum += arr[right];
            while (left <= right && curremtSum > k) {
                curremtSum -= arr[left];
                left++;
            }
            if (curremtSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
