package com.practiceExamples.Array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/single-number/description/
 */

public class Array_17_NumberOnce {

  public static void main(String[] args) {
    System.out.println(numberOnce(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}));
    System.out.println(numberOnceUsingXor(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}));
  }

  static int numberOnce(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int j : arr) {
      map.put(j, map.getOrDefault(j, 0) + 1);
    }

    for (int key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }
    return -1;
  }

  static int numberOnceUsingXor(int[] arr) {
    int result = 0;
    for (int num : arr) {
      result = result ^ num;
    }
    return result;
  }
}
