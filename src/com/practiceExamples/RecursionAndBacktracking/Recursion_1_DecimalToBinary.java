package com.practiceExamples.RecursionAndBacktracking;

public class Recursion_1_DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Decimal to Base -2: " + baseNeg2(-2));

        int decimal = 13;
        System.out.print("Decimal to Binary Using Recursion: ");
        decimalToBinaryUsingRecursion(decimal);

        System.out.print("\nDecimal to Binary: ");
        decimalToBinary(decimal);
    }

    /* https://leetcode.com/problems/convert-to-base-2/ */
    static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            int remainder = n % -2;  // Get the remainder when dividing by -2
            n = n / -2;
            if (remainder < 0) {
                remainder += 2;  // Adjust remainder to be non-negative
                n += 1;  // Compensate by increasing n
            }
            result.insert(0, remainder);  // Prepend remainder to the result string
        }
        return result.toString();
    }

    static void decimalToBinaryUsingRecursion(int n) {
        if (n == 0) return;
        decimalToBinaryUsingRecursion(n / 2);
        System.out.print(n % 2);
    }

    static void decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }
        System.out.println(binary);
    }
}
