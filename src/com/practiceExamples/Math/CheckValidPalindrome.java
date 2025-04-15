package com.practiceExamples.Math;

public class CheckValidPalindrome {

  public static void main(String[] args) {
    System.out.print("\nCheck valid palindrome: " + validPalindrome(-121));
  }

  /* https://leetcode.com/problems/palindrome-number/description/?envType=problem-list-v2&envId=math  */
  public static boolean validPalindrome(int x) {
    int temp = x;
    int remainder = 0;
    x = java.lang.Math.abs(x);
    while (x > 0) {
      remainder = remainder * 10 + (x % 10);
      x = x / 10;
    }
    return remainder == temp;
  }


}
