package com.practiceExamples.Array;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class Array_16_ConsecutiveOnes {

  public static void main(String[] args) {
    System.out.println(maxConsecutiveOnes(new int[]{1, 1, 1, 4, 1, 1, 1, 2, 9}));
    System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 4, 1, 1, 1, 2, 9}));
  }

  static int maxConsecutiveOnes(int[] arr) {
    int maxCount = 0;
    int count = 0;

    for (int j : arr) {
      if (j == 1) {
        count++;
      } else {
        count = 0;
      }
      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }

  static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0;
    int maxCount = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        if (count > maxCount) {
          maxCount = count;
        }
        count = 0;
      }
    }
    return Math.max(count, maxCount);
  }
}
