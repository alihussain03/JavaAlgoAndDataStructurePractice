package com.Sorting;

import java.util.Arrays;
import java.util.List;
import util.CollectionUtil;

// Partitioning
public class QuickSort {

  public static void main(String[] args) {
    int[] array = {3, 6, 8, 10, 1, 2, 1};
    quickSortOfArray(array, 0, array.length - 1);
    CollectionUtil.printArray(array);

    List<Integer>[] examples = new List[]{
        Arrays.asList(4, 2, 6, 8, 3)
    };
    List<Integer> sortedList = sort(examples[0]);
    System.out.println(sortedList);
  }

  static List<Integer> sort(List<Integer> array) {
    quickSort(array, 0, array.size() - 1);
    return array;
  }

  static void quickSort(List<Integer> array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quickSort(array, low, pivotIndex - 1);
      quickSort(array, pivotIndex + 1, high);
    }
  }

  static int partition(List<Integer> array, int low, int high) {
    int pivot = array.get(high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array.get(j) < pivot) {
        i++;
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
      }
    }

    int temp = array.get(i + 1);
    array.set(i + 1, array.get(high));
    array.set(high, temp);

    return i + 1;
  }


  static void quickSortOfArray(int[] array, int low, int high) {
    if (low < high) {
      int pivot = findPivot(array, low, high);
      quickSortOfArray(array, low, pivot - 1);
      quickSortOfArray(array, pivot + 1, high);
    }
  }

  // find a pivot and place it in its correct place. Pivot can be any element
  // 3 steps:
  // 1) check element greater than pivot
  // 2) check element lesser than pivot
  // 3) swap result of first and second
  static int findPivot(int[] array, int low, int high) {
    int i = low + 1, j = high;
    int pivot = array[low];
    while (i <= j) {
      while (i <= high && array[i] <= pivot) { // 1)
        i++;
      }
      while (j >= low && array[j] > pivot) { // 2)
        j--;
      }
      if (i < j) {
        CollectionUtil.swapArrayElements(array, i, j); // 3)
      }
    }
    CollectionUtil.swapArrayElements(array, low, j);
    return j;
  }
}