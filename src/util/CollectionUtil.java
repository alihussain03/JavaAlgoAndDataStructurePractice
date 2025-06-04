package util;

import java.util.List;

public class CollectionUtil {

  public static void swapArrayElements(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static void printArray(int[] array) {
    for (int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void printList(List<List<Integer>> data) {
    for (List<Integer> row : data) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}
