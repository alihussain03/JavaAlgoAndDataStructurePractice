package com.practiceExamples.String;

/**
 * A palindrome is a sequence of characters that reads the same forward and backward, ignoring spaces, punctuation, and
 * case differences.
 */

public class String_2_CheckPalindrome {

  public static void main(String[] args) {
    String[] testCases = {
        "",
        "a",
        "Aba",
        "A man a plan a canal Panama",
        "A man, a plan, a canal: Panama",
        "12321",
        "1A2B2A1",
        "àbAà",
        "\nA\t",
        "RADAR1",
        null
    };

    for (String testCase : testCases) {
      System.out.println("Is \"" + testCase + "\" a palindrome? " + isPalindrome(testCase));
    }
  }

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

