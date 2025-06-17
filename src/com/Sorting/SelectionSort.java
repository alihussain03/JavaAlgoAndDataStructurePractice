package com.Sorting;

import util.CollectionUtil;

/*
 * In each iteration, find the smallest element in the unsorted portion(left portion starting from 0 index)
 * of the array and swap it with the first unsorted element. After each pass, the left portion (from index 0 to i)
 * becomes sorted, while the right portion remains unsorted.
 * for i = 0 to n-1: find min(i → n-1), swap(min, i)
 */

public class SelectionSort {

  public static void main(String[] args) {
    int[] array = {8, 1, 2, 6, 5,};
    selectionSort(array);

    array = new int[]{13, 46, 24, 9, 20, 8};
    selectionSortUsingRecursion(array, 0);
    System.out.print("Selection Sort Using Recursion: ");
    CollectionUtil.printArray(array);
  }

  /*
   * Time complexity: O(n²)
   * Space complexity: O(1)
   */
  static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      // Swap the found minimum element with the first unsorted element
      if (minIndex != i) {
        CollectionUtil.swapArrayElements(array, i, minIndex);
      }
    }

    System.out.print("Selection sort: ");
    CollectionUtil.printArray(array);
  }

  static int[] selectionSortUsingRecursion(int[] array, int index) {
    if (index == array.length - 1) {
      return array;
    }
    int minIndex = index;
    for (int j = index + 1; j < array.length; j++) {
      if (array[j] < array[minIndex]) {
        minIndex = j;
      }
    }
    // Swap the found minimum element with the first unsorted element
    if (minIndex != index) {
      CollectionUtil.swapArrayElements(array, index, minIndex);
    }
    return selectionSortUsingRecursion(array, index + 1);
  }
}