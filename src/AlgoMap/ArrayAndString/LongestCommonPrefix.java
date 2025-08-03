package AlgoMap.ArrayAndString;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/description/">LeetCode</a>
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    GeneralUtil.newFunctionCall();
    System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }

  static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {
      String current = strs[i];
      int j = 0;
      while (j < prefix.length() && j < current.length() && prefix.charAt(j) == current.charAt(j)) {
        j++;
      }
      prefix = prefix.substring(0, j);

      if (prefix.isEmpty()) {
        return "";
      }
    }
    return prefix;
  }
}