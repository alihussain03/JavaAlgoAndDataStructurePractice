package com.practiceExamples.RecursionAndBacktracking;

public class Recursion_2_Reverse {
    public static void main(String[] args) {

        System.out.println("\nReverse Number Using Recursion : " + reverseNumberUsingRecursion(543210, 0));
        System.out.println("\nReverse String Using Recursion : " + reverseArrayUsingRecursion("Hello", ""));
        System.out.println("\nReverse String Using Recursion : " + reverseStringUsingRecursion1("Hello", 0, ""));
        System.out.print("\nReverse Array Using Recursion : ");
        char[] data = new char[]{'H', 'e'};
        data = reverseArrayUsingRecursion(data, 0, data.length - 1);
        for (char d : data) {
            System.out.print(d);
        }
        reverseArray(data);
    }

    static int reverseNumberUsingRecursion(int n, int result) {
        if (n == 0) return result;
        result = result * 10 + (n % 10);
        return reverseNumberUsingRecursion(n / 10, result);
    }

    static String reverseArrayUsingRecursion(String str, String result) {
        if (str.isEmpty()) return result;
        result += (str.charAt(str.length() - 1));
        return reverseArrayUsingRecursion(str.substring(0, str.length() - 1), result);
    }

    static String reverseStringUsingRecursion1(String str, int index, String result) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (index == str.length()) {
            return result;
        }
        result = str.charAt(index) + result;
        return reverseStringUsingRecursion1(str, index + 1, result);
    }

    static void reverseArray(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    /* https://leetcode.com/problems/reverse-string/description/ */
    static char[] reverseArrayUsingRecursion(char[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        return reverseArrayUsingRecursion(arr, ++start, --end);
    }


}
