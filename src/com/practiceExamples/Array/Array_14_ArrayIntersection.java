package com.practiceExamples.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Array_14_ArrayIntersection {

  public static void main(String[] args) {
    System.out.println("Array Intersection");
    System.out.println(
        Arrays.toString(findIntersectionUsingTwoPointer(new int[]{1, 2, 4, 5, 6}, new int[]{2, 3, 5, 7})));
    System.out.println(Arrays.toString(findIntersection(new int[]{1, 2, 4, 5, 6}, new int[]{2, 3, 5, 7})));
  }

  public static int[] findIntersectionUsingTwoPointer(int[] arr1, int[] arr2) {
    int i = 0, j = 0;
    int n = arr1.length;
    int m = arr2.length;
    ArrayList<Integer> intersection = new ArrayList<>();
    while (i < n && j < m) {
      if (arr1[i] == arr2[j]) {
        intersection.add(arr1[i]);
        i++;
        j++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else {
        j++;
      }

    }
    int[] result = new int[intersection.size()];
    for (int k = 0; k < intersection.size(); k++) {
      result[k] = intersection.get(k);
    }

    // Print the result array
    for (int val : result) {
      System.out.println(val);
    }
    return null;
  }

  public static int[] findIntersection(int[] arr1, int[] arr2) {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    ArrayList<Integer> intersection = new ArrayList<>();

    // Step 1: Populate the frequency map with elements from arr1
    for (int num : arr1) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    // Step 2: Find intersections with elements from arr2
    for (int num : arr2) {
      if (freqMap.containsKey(num) && freqMap.get(num) > 0 && !intersection.contains(num)) {
        intersection.add(num);
        // Decrease the frequency of the current number
        freqMap.put(num, freqMap.get(num) - 1);
      }
    }
    return intersection.stream().mapToInt(i -> i).toArray();
  }
}
