package AlgoMap.ArrayAndString;

import util.CollectionUtil;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">LeetCode</a>
 */
public class ArrayProduct {

  public static void main(String[] args) {
    int[] nums = productExceptSelf(new int[]{1, 2, 3, 4});
    CollectionUtil.printArray(nums);
    GeneralUtil.newFunctionCall();

    nums = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    CollectionUtil.printArray(nums);
    GeneralUtil.newFunctionCall();

  }

  static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixProductArray = new int[n];
    int[] postFixProductArray = new int[n];
    int[] result = new int[n];
    int product = 1;

    for (int i = 0; i < nums.length; i++) {
      prefixProductArray[i] = product;
      product *= nums[i];
    }

    product = 1;
    for (int i = n - 1; i >= 0; i--) {
      postFixProductArray[i] = product;
      product *= nums[i];
    }

    for (int i = 0; i < n; i++) {
      result[i] = prefixProductArray[i] * postFixProductArray[i];
    }
    return result;
  }
}