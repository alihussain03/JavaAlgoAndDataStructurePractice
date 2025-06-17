package Grokking.Recursion.Easy;

public class CountOccurrences {

  public static void main(String[] args) {
    int[] array = new int[]{2, 4, 6, 8, 4};
    System.out.println("" + countOccurrences(array, 4));
  }

  static int countOccurrences(int[] arr, int key) {
    return countOccurrencesHelper(arr, key, 0);
  }

  private static int countOccurrencesHelper(int[] arr, int key, int index) {
    if (index >= arr.length) {
      return 0;
    }
    int count = arr[index] == key ? 1 : 0;
    int totalCount = count + countOccurrencesHelper(arr, key, index + 1);
    return totalCount;
  }
}