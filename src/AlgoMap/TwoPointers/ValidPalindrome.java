package AlgoMap.TwoPointers;

import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">LeetCode</a>
 */
public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    GeneralUtil.newFunctionCall();
    System.out.println(isPalindrome("race a car"));
    GeneralUtil.newFunctionCall();
    System.out.println(isPalindrome(" "));
    GeneralUtil.newFunctionCall();
    System.out.println(isPalindrome("OP"));
  }

  static boolean isPalindrome(String str) {
    str = str.toLowerCase();
    int left = 0, right = str.length() - 1;
    while (left <= right) {
      if (!Character.isLetterOrDigit(str.charAt(left))) {
        left++;
      } else if (!Character.isLetterOrDigit(str.charAt(right))) {
        right--;
      } else if (str.charAt(left) != str.charAt(right)) {
        return false;
      } else {
        left++;
        right--;
      }
    }
    return true;
  }
}