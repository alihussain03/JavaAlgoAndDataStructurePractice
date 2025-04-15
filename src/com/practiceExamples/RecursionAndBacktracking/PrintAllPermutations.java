package com.practiceExamples.RecursionAndBacktracking;

import java.util.Arrays;
import util.CollectionUtil;

public class PrintAllPermutations {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    printAllPermutations(arr, 0);
  }

  private static void printAllPermutations(int[] arr, int index) {
    int n = arr.length;
    if (index == n - 1) {
      System.out.println(Arrays.toString(arr));
      return;
    }
    for (int i = index; i < n; i++) {
      CollectionUtil.swapArrayElements(arr, index, i);
      printAllPermutations(arr, index + 1);
      CollectionUtil.swapArrayElements(arr, index, i);
    }
  }
}
