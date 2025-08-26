package AlgoMap.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import util.CollectionUtil;
import util.GeneralUtil;


/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/">LeetCode</a>
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
    CollectionUtil.printArray(res);
    GeneralUtil.newFunctionCall();
    res = twoSum(new int[]{2, 3, 4}, 6);
    CollectionUtil.printArray(res);
    GeneralUtil.newFunctionCall();
    res = twoSum(new int[]{-1, 0}, -1);
    CollectionUtil.printArray(res);
  }

  static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement) + 1, i + 1};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[0];
  }
}