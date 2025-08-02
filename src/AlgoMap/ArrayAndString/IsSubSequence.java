package AlgoMap.ArrayAndString;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/description/">LeetCode</a>
 */
public class IsSubSequence {

  public static void main(String[] args) {
    System.out.println(isSubsequence("abc", "ahbgdc"));
    GeneralUtil.newFunctionCall();
    System.out.println(isSubsequence("axc", "ahbgdc"));
  }

  static boolean isSubsequence(String s, String t) {
    int currentIndexForS = 0;
    int currentIndexForT = 0;

    while (currentIndexForS < s.length() && currentIndexForT < t.length()) {
      if (s.charAt(currentIndexForS) == t.charAt(currentIndexForT)) {
        currentIndexForS++;
        currentIndexForT++;
      } else {
        currentIndexForT++;
      }
    }
    return currentIndexForS == s.length();
  }
}