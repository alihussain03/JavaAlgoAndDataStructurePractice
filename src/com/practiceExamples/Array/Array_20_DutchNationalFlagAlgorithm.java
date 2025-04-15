package com.practiceExamples.Array;

/**
 * https://leetcode.com/problems/sort-colors/ Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 * <p>
 * arr[0….low-1] contains 0. [Extreme left part] arr[low….mid-1] contains 1. arr[high+1….n-1] contains 2. [Extreme right
 * part], n = size of the array
 */
public class Array_20_DutchNationalFlagAlgorithm {

  public static void main(String[] args) {

    int[] arr = new int[]{0, 2, 1, 2, 0, 1};
    sortArray(arr, arr.length);
    System.out.println("After sorting:");
    for (Integer integer : arr) {
      System.out.print(integer + " ");
    }
  }

  public static void sortArray(int[] arr, int n) {
    int low = 0, mid = 0, high = n - 1; // 3 pointers

    while (mid <= high) {
      if (arr[mid] == 0) {
        // Swap arr[low] and arr[mid]
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        // Swap arr[mid] and arr[high]
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
        high--;
      }
    }
  }
}
