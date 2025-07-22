package AlgoMap.ArrayAndString;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/find-closest-number-to-zero/description/">LeetCode</a>
 */
public class FindClosestNumberToZero {

  public static void main(String[] args) {
    int closestNumber = findClosestNumber(new int[]{-4, -2, 1, 4, 8});
    System.out.println(closestNumber);

    GeneralUtil.newFunctionCall();
    System.out.println(findClosestNumber(new int[]{2, -1, 1}));
  }

  static int findClosestNumber(int[] nums) {
    int closest = nums[0];
    for (int num : nums) {
      int absNum = Math.abs(num);
      int absClosest = Math.abs(closest);

      if (absNum < absClosest || (absNum == absClosest && num > closest)) {
        closest = num;
      }
    }
    return closest;
  }
}