package AlgoMap.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/3sum/description/">LeetCode</a>
 */
public class ThreeSum {

  public static void main(String[] args) {
    List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    res.forEach(System.out::println);
    GeneralUtil.newFunctionCall();
    res = threeSum(new int[]{0, 1, 1});
    res.forEach(System.out::println);
    GeneralUtil.newFunctionCall();
    res = threeSum(new int[]{0, 0, 0, 0});
    res.forEach(System.out::println);
    GeneralUtil.newFunctionCall();
    res = threeSum(new int[]{1, 2, -2, -1});
    res.forEach(System.out::println);
  }

  static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}