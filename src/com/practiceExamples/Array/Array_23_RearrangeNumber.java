package com.practiceExamples.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */
public class Array_23_RearrangeNumber {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    Integer[] array = {3, 1, -2, -5, 2, 4};

    // Convert array to ArrayList
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

    System.out.println(Arrays.toString(new ArrayList[]{RearrangeBySign(arrayList, arrayList.size())}));
  }

  static int[] rearrangeArray(int[] nums) {
    int[] arr = new int[nums.length];
    int positiveIndex = 0;
    int negativeIndex = 1;
    for (int j : nums) {
      if (j > 0) {
        arr[positiveIndex] = j;
        positiveIndex += 2;
      } else {
        arr[negativeIndex] = j;
        negativeIndex += 2;
      }
    }
    return arr;
  }

  public static ArrayList<Integer> RearrangeBySign(ArrayList<Integer> arr, int n) {
    // Define two ArrayLists for storing positive and negative elements
    ArrayList<Integer> pos = new ArrayList<>();
    ArrayList<Integer> neg = new ArrayList<>();

    // Segregate the array into positives and negatives
    for (int i = 0; i < n; i++) {
      if (arr.get(i) > 0) {
        pos.add(arr.get(i));
      } else if (arr.get(i) < 0) {
        neg.add(arr.get(i));
      }
    }

    ArrayList<Integer> result = getIntegersBruteForce(n, pos, neg);

    return result;
  }

  private static ArrayList<Integer> getIntegersBruteForce(int n, ArrayList<Integer> pos, ArrayList<Integer> neg) {
    ArrayList<Integer> result = new ArrayList<>(n);
    // Initialize result with zeros to avoid index out of bounds errors when setting values
    for (int i = 0; i < n; i++) {
      result.add(0);
    }

    // Fill array alternatively with positive and negative values
    int i = 0, j = 0, k = 0;
    while (i < pos.size() && j < neg.size()) {
      result.set(k++, pos.get(i++));
      result.set(k++, neg.get(j++));
    }

    // Append the remaining positives
    while (i < pos.size()) {
      result.set(k++, pos.get(i++));
    }

    // Append the remaining negatives
    while (j < neg.size()) {
      result.set(k++, neg.get(j++));
    }
    return result;
  }
}