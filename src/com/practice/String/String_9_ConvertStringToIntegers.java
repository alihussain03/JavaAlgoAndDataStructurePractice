package com.practice.String;

public class String_9_ConvertStringToIntegers {
    public static void main(String[] args) {
        String str = "123";
        System.out.println("String \"" + str + "\" converted to integer: " + convertStringToInt(str));
    }

    private static int convertStringToInt(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        int result = 0;
        int i = 0;
        boolean isNegative = false;

        // Handle optional sign
        if (str.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Invalid character");
            }

            result = result * 10 + (c - '0');
        }
        return result;
    }
}
