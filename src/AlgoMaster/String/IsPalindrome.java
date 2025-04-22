package AlgoMaster.String;

public class IsPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("RAD8AR"));
  }

  /* https://leetcode.com/problems/valid-palindrome/ */
  public static boolean isPalindrome(String str) {
    if (str == null || str.isEmpty()) {
      return true; // An empty string or null is considered a palindrome
    }

    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      // Move left pointer to the next alphanumeric character
      while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
        left++;
      }
      // Move right pointer to the previous alphanumeric character
      while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
        right--;
      }
      // Compare characters ignoring case
      if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
