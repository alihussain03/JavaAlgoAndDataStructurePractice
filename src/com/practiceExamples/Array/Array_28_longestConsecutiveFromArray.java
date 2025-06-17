package com.practiceExamples.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class Array_28_longestConsecutiveFromArray {

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[]{1, 12, 2, 3, 9, 4, 5, 6, 1}));
  }

  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxOccurrence = 1;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int integer : set) {

      if (!set.contains(integer - 1)) {
        int currenCount = 1;

        while (set.contains(integer + 1)) {
          integer = integer + 1;
          currenCount++;
        }
        maxOccurrence = Math.max(maxOccurrence, currenCount);
      }
    }
    return maxOccurrence;
  }
}