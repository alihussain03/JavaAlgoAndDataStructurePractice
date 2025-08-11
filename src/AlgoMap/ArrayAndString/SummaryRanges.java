package AlgoMap.ArrayAndString;

import java.util.ArrayList;
import java.util.List;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/description/">LeetCode</a>
 */
public class SummaryRanges {

  public static void main(String[] args) {
    List<String> ranges = summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
    ranges.forEach(System.out::println);
    GeneralUtil.newFunctionCall();
    ranges = summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    ranges.forEach(System.out::println);

  }

  static List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    int start = 0;
    for (int i = 1; i <= nums.length; i++) {
      if (i == nums.length || nums[i] != nums[i - 1] + 1) {
        if (start == i - 1) {
          result.add(String.valueOf(nums[start]));
        } else {
          result.add(nums[start] + "->" + nums[i - 1]);
        }
        start = i;
      }
    }
    return result;
  }
}