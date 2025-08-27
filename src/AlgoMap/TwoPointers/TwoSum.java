package AlgoMap.TwoPointers;

import java.util.Arrays;
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
    System.out.println("--------Using Two Pointers --------");
    CollectionUtil.printArray(twoSumUsingTwoPointers(new int[]{2, 3, 4}, 6));
    GeneralUtil.newFunctionCall();
    CollectionUtil.printArray(twoSumUsingTwoPointers(new int[]{2, 7, 11, 15}, 9));
    GeneralUtil.newFunctionCall();
    CollectionUtil.printArray(twoSum(new int[]{-1, 0}, -1));
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

  static int[] twoSumUsingTwoPointers(int[] nums, int target) {
    int n = nums.length;
    int[][] pairs = new int[n][2];
    for (int i = 0; i < n; i++) {
      pairs[i][0] = nums[i];
      pairs[i][1] = i + 1; // store 1-based index
    }
    Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

    int left = 0, right = n - 1;
    while (left < right) {
      int sum = pairs[left][0] + pairs[right][0];
      if (sum == target) {
        return new int[]{pairs[left][1], pairs[right][1]};
      } else if (sum > target) {
        right--;
      } else {
        left++;
      }
    }
    return new int[0];
  }
}