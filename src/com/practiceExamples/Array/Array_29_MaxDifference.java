package com.practiceExamples.Array;

/* https://leetcode.com/problems/maximum-difference-between-increasing-elements/ */
public class Array_29_MaxDifference {

  public static void main(String[] args) {
    int nums[] = new int[]{1, 5, 2, 10};
    System.out.println(maximumDifference(nums));
  }

  static int maximumDifference(int[] nums) {
    int min = nums[0];
    int maxDifference = -1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > min) {
        maxDifference = Math.max(maxDifference, nums[i] - min);
      } else {
        min = nums[i];
      }
    }
    return maxDifference;
  }
}
