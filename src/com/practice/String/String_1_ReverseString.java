package com.practice.String;

public class String_1_ReverseString {
    public static void main(String[] args) {
        String str = "Reverse it without using any built in function";
        System.out.println("Reverse using for loop      : " + reverseStringUsingForLoop(str));
        System.out.println("Reverse using Recursion     : " + reverseStringUsingRecursion(str));
        System.out.println("Reverse using Builder class : " + reverseStringUsingBuilderClass(str));
    }

    public static String reverseStringUsingForLoop(String input) {
        StringBuilder sb = new StringBuilder();
        // char[] chars = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringUsingRecursion(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseStringUsingRecursion(input.substring(1)) + input.charAt(0);
    }

    public static String reverseStringUsingBuilderClass(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return new StringBuilder(input).reverse().toString();
    }
}
