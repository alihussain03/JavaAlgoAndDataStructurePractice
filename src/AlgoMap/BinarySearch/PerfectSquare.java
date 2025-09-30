package AlgoMap.BinarySearch;

import util.GeneralUtil;

/* https://leetcode.com/problems/valid-perfect-square/ */
public class PerfectSquare {

  public static void main(String[] args) {
    System.out.println(isPerfectSquare(16));
    GeneralUtil.newFunctionCall();
    System.out.println(isPerfectSquare(14));
  }

  static boolean isPerfectSquare(int num) {
    int start = 1, end = num;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int sqrt = mid * mid;
      if (sqrt == num) {
        return true;
      } else if (sqrt < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }
}
