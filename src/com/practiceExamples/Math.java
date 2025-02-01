package com.practiceExamples;

public class Math {
    public static void main(String[] args) {
        System.out.print("Reverse Number & Checking overflow as well: " + reverse(1534236469));
        System.out.print("\nCheck valid palindrome: " + validPalindrome(-121));

    }

    /* https://leetcode.com/problems/convert-date-to-binary/description/ */
    public static int reverse(int x) {
        int remainder = 0;
        boolean isNegative = x < 0;
        x = java.lang.Math.abs(x);
        while (x > 0) {
            if (remainder > (Integer.MAX_VALUE / 10) || (remainder == (Integer.MAX_VALUE / 10))) {
                return 0;  // Return 0 if overflow occurs
            }
            remainder = remainder * 10 + (x % 10);
            x = x / 10;
        }
        return isNegative ? -remainder : remainder;
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
