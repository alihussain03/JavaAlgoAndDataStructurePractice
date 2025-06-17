package Grokking.Recursion.Medium;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 10, 18, 20};
    int target = 18;
    int result = binarySearchUsingIteration(arr, target);
    System.out.println(result);
    System.out.println("\nBinary Search using Recursion ");
    result = binarySearchUsingRecursion(arr, target, 0, arr.length - 1);
    System.out.println(result);
  }

  static int binarySearchUsingIteration(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  static int binarySearchUsingRecursion(int[] arr, int target, int low, int high) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] < target) {
      return binarySearchUsingRecursion(arr, target, mid + 1, high);
    } else {
      return binarySearchUsingRecursion(arr, target, low, mid - 1);
    }
  }
}