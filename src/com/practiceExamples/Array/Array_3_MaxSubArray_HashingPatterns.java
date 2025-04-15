package com.practiceExamples.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Array_3_MaxSubArray_HashingPatterns {

  public static void main(String[] args) {
    int[] arr = {10, 0, 1, 5, 2, 7};
    int k = 5;
    System.out.println("isSubarraySumPresent: " + isSubarraySumEqualToK(arr, k));

    arr = new int[]{1, 2, 3, 4, 5};
    k = 9;
    String result = findIndicesOfSubarrayWithSumK(arr, k).stream().map(String::valueOf)
        .collect(Collectors.joining(", "));
    System.out.println("Indexes are : " + result);

    arr = new int[]{10, 0, 0, 5, 2, 7};
    findLongestSubArrayLengthWithSumK(arr);

    arr = new int[]{10, 0, 0, 5, 2, 7};
    System.out.println("Total Sub array with sum k: " + getTotalSubArraysWithSumK(arr, k));

    System.out.println("Smallest sub array with k sum is: " + findSmallestKSumSubArray(arr, k));
  }

  static boolean isSubarraySumEqualToK(int[] arr, int k) {
    int sum = 0;
    HashSet<Integer> set = new HashSet<>();
    set.add(0);
    for (int j : arr) {
      sum += j;
      int diff = sum - k;
      if (set.contains(diff)) {
        return true;
      } else {
        set.add(sum);
      }
    }
    return false;
  }

  // https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
  static ArrayList<Integer> findIndicesOfSubarrayWithSumK(int[] arr, int K) {
    int sum = 0;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(-1);
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      int diff = sum - K;
      if (map.containsKey(diff)) {
        list.set(0, map.get(diff) + 1 + 1);
        list.add(i + 1);
        return list;
      } else {
        map.put(sum, i);
      }
    }
    return list;
  }

  /**
   * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
   * Variable-size Sliding Window or Two Pointers (with sum tracking) This function finds the longest subarray in arr
   * where the total of its elements equals to the given sum. {10, 5, 2, 7, 1, 9};  sum = 15; output = 4 -> { 5, 2, 7,
   * 1}
   */
  static void findLongestSubArrayLengthWithSumK(int[] arr) {
    int k = 15;
    int n = arr.length;
    System.out.println("Using Brute Force: " + findLongestSubArrayLengthWithSumKUsingBruteForce(arr, k, n));
    System.out.println("Using Hashmap Force: " + findLongestSubArrayLengthWithSumKUsingHashMap(arr, k, n));
    System.out.println("Using 2 Pointers: " + findLongestSubArrayLengthWithSumKUsingTwoPointers(arr, k, n));
  }

  public static int findLongestSubArrayLengthWithSumKUsingBruteForce(int[] arr, int k, int n) {
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

  public static int findLongestSubArrayLengthWithSumKUsingHashMap(int[] arr, int k, int n) {
    int max = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      int diff = sum - k;
      if (map.containsKey(diff)) {
        int length = i - map.get(diff);
        max = Math.max(max, length);
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return max;
  }

  public static int findLongestSubArrayLengthWithSumKUsingTwoPointers(int[] arr, int k, int n) {
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

  /* https://leetcode.com/problems/subarray-sum-equals-k/description/ */
  static int getTotalSubArraysWithSumK(int[] arr, int k) {// code here
    int count = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int j : arr) {
      sum += j;
      int diff = sum - k;
      count += map.getOrDefault(diff, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  // similar to findLongestSubArrayLengthWithSumKUsingHashMap
  static int findSmallestKSumSubArray(int[] arr, int K) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      int diff = sum - K;
      if (map.containsKey(diff)) {
        min = Math.min(min, i - map.get(diff));
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return (min == Integer.MAX_VALUE) ? -1 : min;
  }
}
