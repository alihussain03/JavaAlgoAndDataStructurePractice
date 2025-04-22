package AlgoMaster.String;

public class IsSubsequence {

  public static void main(String[] args) {
    String s = "axc";
    String t = "ahbgdc";
    System.out.println(isSubsequenceExist(s, t));
  }

  /* https://leetcode.com/problems/is-subsequence/description/ */
  static boolean isSubsequenceExist(String s, String t) {
    int i = 0, j = 0;
    int count = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
        count++;
      } else {
        j++;
      }
    }
    return s.length() == count;
  }

}
