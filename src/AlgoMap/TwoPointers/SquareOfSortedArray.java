package AlgoMap.TwoPointers;

import java.util.Arrays;
import util.CollectionUtil;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/">LeetCode</a>
 */
public class SquareOfSortedArray {

  public static void main(String[] args) {
    int[] returnArray = sortedSquares(new int[]{-4, -1, 0, 3, 10});
    CollectionUtil.printArray(returnArray);
    GeneralUtil.newFunctionCall();
    returnArray = sortedSquaresUsingTwoPointers(new int[]{-4, -1, 0, 3, 10});
    CollectionUtil.printArray(returnArray);
  }

  static int[] sortedSquares(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] * nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }

  static int[] sortedSquaresUsingTwoPointers(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int left = 0, right = n - 1, pos = n - 1;

    while (left <= right) {
      int leftSquare = nums[left] * nums[left];
      int rightSquare = nums[right] * nums[right];

      if (leftSquare > rightSquare) {
        result[pos--] = leftSquare;
        left++;
      } else {
        result[pos--] = rightSquare;
        right--;
      }
    }
    return result;
  }
}
