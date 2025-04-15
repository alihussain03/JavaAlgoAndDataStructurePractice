package com.practiceExamples.Array;

import java.util.Arrays;

/* https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/ */
public class Array_1_MaxMinOfArray {

  public static void main(String[] args) {
    System.out.println("Max and Min of Array");
    int[] arr = {1000, 11, 445, 1, 330, 3000};
    int[] result = findMaxMin(arr);
    System.out.println("Max: " + result[0] + " Min: " + result[1]);
    System.out.println("Max and Min of Array Using 2 Pointers: ");
    result = findMaxMin2(arr);
    System.out.println("Max: " + result[0] + " Min: " + result[1]);
    result = findMaxMinUsingLambda(arr);
    System.out.println("Max: " + result[0] + " Min: " + result[1]);
  }

  public static int[] findMaxMin(int[] arr) {
    int[] result = new int[2];
    int max = arr[0];
    int min = arr[0];
    return getInts(arr, result, max, min);
  }

  public static int[] findMaxMin2(int[] arr) {
    int[] result = new int[2];
    int max = arr[0];
    int min = arr[0];
    return getIntsUsingTwoPointer(arr, result, max, min);
  }

  private static int[] getInts(int[] arr, int[] result, int max, int min) {
    for (int i : arr) {
      if (i > max) {
        max = i;
      }
      if (i < min) {
        min = i;
      }
    }
    result[0] = max;
    result[1] = min;
    return result;
  }

  private static int[] getIntsUsingTwoPointer(int[] arr, int[] result, int max, int min) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Array must contain at least one element");
    }
    int left = 0, right = arr.length - 1;
    while (left < right) {
      max = Math.max(max, Math.max(arr[left], arr[right]));
      min = Math.min(min, Math.min(arr[left], arr[right]));
      left++;
      right--;
    }
    if (left == right) {
      max = Math.max(max, arr[left]);
      min = Math.min(min, arr[left]);
    }
    result[0] = max;
    result[1] = min;
    return result;
  }

  public static int[] findMaxMinUsingLambda(int[] arr) {
    int max = Arrays.stream(arr).max().orElseThrow();
    int min = Arrays.stream(arr).min().orElseThrow();
    return new int[]{max, min};
  }
}
