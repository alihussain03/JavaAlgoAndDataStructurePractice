package com.practice.String;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Check if a string contains only integers
 */
public class String_7_CheckIntegers {
    public static void main(String[] args) {
        String str = "123";
        System.out.println("String \"" + str + "\" contains only integers: " + checkForTheIntegers(str));
        System.out.println("String \"" + str + "\" contains only integers: " + isAllDigits(str));
        System.out.println("String \"" + str + "\" contains only integers: " + isAllDigitsUsingStream(str));
    }

    private static boolean checkForTheIntegers(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllDigits(String str) {
        return str != null && str.matches("\\d+");
    }

    public static boolean isAllDigitsUsingStream(String str) {
        return str != null && !str.isEmpty() && str.chars().allMatch(Character::isDigit);
    }
}
