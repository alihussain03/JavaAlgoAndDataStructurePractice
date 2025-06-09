package AlgoMaster.String;

/* https://leetcode.com/problems/longest-common-prefix/description/ */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }

  static String longestCommonPrefix(String[] strs) {
    if (strs.length < 1) {
      return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }
}