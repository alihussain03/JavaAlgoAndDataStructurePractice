package AlgoMaster.Array;

import util.CollectionUtil;

/* https://leetcode.com/problems/move-zeroes/ */
public class MoveZerosToRight {

  public static void main(String[] args) {
    int[] numArray = {0, 1, 0, 3, 12};
    System.out.println("----------\nMove zeros to end: ");
    moveZerosToEnd(numArray);
    System.out.println("----------\nMove zeros to end: ");
    moveZerosToEnd2(numArray);
  }

  private static void moveZerosToEnd(int[] nums) {
    int n = nums.length;
    int nonZeroIndex = 0;
    // Move non-zero elements forward
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        CollectionUtil.swapArrayElements(nums, i, nonZeroIndex);
        nonZeroIndex++;
      }
    }
    CollectionUtil.printArray(nums);
  }

  private static void moveZerosToEnd2(int[] arr) {
    int slow = 0;
    for (int fast = 0; fast < arr.length; fast++) {
      if (arr[fast] != 0) {
        CollectionUtil.swapArrayElements(arr, fast, slow);
        slow++;
      }
    }
    CollectionUtil.printArray(arr);
  }
}