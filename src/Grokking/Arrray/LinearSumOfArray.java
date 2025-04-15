package Grokking.Arrray;

import util.CollectionUtil;

public class LinearSumOfArray {

  public static void main(String[] args) {
    int[] nums = {7, 1, 4};
    int[] result = linearSumOfArray(nums);
    CollectionUtil.printArray(result);
  }

  static int[] linearSumOfArray(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] + nums[i];
    }
    return result;
  }
}
