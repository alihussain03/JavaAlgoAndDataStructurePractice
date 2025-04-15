package com.practiceExamples.Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/ Input: nums = [1,2,3] Output: [1,3,2]
 * https://www.youtube.com/watch?v=6ENl3OwwxLg
 */
public class Array_25_NextPermutation {

  public static void nextPermutation(int[] nums) {
    int n = nums.length;
    int k = n - 2;

    // Step 1: Find the first decreasing element from the end
    while (k >= 0 && nums[k] >= nums[k + 1]) {
      k--;
    }

    // Step 2: If such an element exists, find the element to swap with
    if (k >= 0) {
      int j = n - 1;
      // Find the smallest element greater than nums[k]
      while (nums[j] <= nums[k]) {
        j--;
      }
      // Swap nums[k] and nums[j]
      swap(nums, k, j);
    }

    // Step 3: Reverse the array from k + 1 to the end to get the next smallest permutation
    reverse(nums, k + 1, n - 1);
  }

  // Helper method to swap two elements in the array
  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  // Helper method to reverse part of the array from start to end
  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    // Example usage
    int[] arr = {2, 3, 1,};
    System.out.println("Original Array: " + Arrays.toString(arr));

    nextPermutation(arr);
    System.out.println("Next Permutation: " + Arrays.toString(arr));
  }
}

