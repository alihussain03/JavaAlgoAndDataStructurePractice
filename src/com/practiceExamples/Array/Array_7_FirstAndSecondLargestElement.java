package com.practiceExamples.Array;

/**
 * https://www.geeksforgeeks.org/find-second-largest-element-array/
 */
public class Array_7_FirstAndSecondLargestElement {

  public static void main(String[] args) {
    int[] arr = {10, 5, 8, 7, 6};
    System.out.println("First Largest: " + firstLargest(arr));
    System.out.println("Second Largest: " + secondLargest(arr));
    System.out.println("First and Second Min: " + minAnd2ndMin(new int[]{1, 1, 1}));
  }

  private static int firstLargest(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must not be empty");
    }
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  private static int secondLargest(int[] arr) {
    if (arr == null || arr.length < 2) {
      throw new IllegalArgumentException("Array must not be empty");
    }
    int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > firstMax) {
        secondMax = firstMax;
        firstMax = arr[i];
      } else if (arr[i] > secondMax && arr[i] != firstMax) {
        secondMax = arr[i];
      }
    }
    return secondMax;
  }

  /**
   * https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
   */
  public static int[] minAnd2ndMin(int arr[]) {
    int firstMax = Integer.MAX_VALUE, secondMax = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < firstMax) {
        secondMax = firstMax;
        firstMax = arr[i];
      } else if (arr[i] < secondMax && arr[i] != firstMax) {
        secondMax = arr[i];
      }
    }
    if (firstMax == Integer.MAX_VALUE || secondMax == Integer.MAX_VALUE) {
      return new int[]{-1, -1};
    }
    return new int[]{firstMax, secondMax};
  }
}