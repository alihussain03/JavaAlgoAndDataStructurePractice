package AlgoMap.BinarySearch;

import util.GeneralUtil;

/**
 * https://leetcode.com/problems/binary-search/description/
 */
public class ArraySearch {

  public static void main(String[] args) {
    System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    GeneralUtil.newFunctionCall();
    System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
  }

  static int search(int[] nums, int target) {
    int mid = 0;
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (nums[mid] > target) {
        end = mid - 1;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}