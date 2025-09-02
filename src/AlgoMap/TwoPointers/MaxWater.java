package AlgoMap.TwoPointers;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode</a>
 */
public class MaxWater {

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    GeneralUtil.newFunctionCall();
    System.out.println(maxArea(new int[]{1, 1}));
    GeneralUtil.newFunctionCall();
  }

  static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    while (left < right) {
      int currentArea = Math.min(height[right], height[left]) * (right - left);
      maxArea = Math.max(currentArea, maxArea);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}