package com.practiceExamples.RecursionAndBacktracking;

public class Recursion_1_DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Decimal to Base -2: " + baseNeg2(-2));

        int decimal = 10;
        System.out.print("Decimal to Binary Using Recursion: ");
        decimalToBinaryUsingRecursion(decimal);
    }

    /* https://leetcode.com/problems/convert-to-base-2/
     *
     * In base -2, the remainder should always be either 0 or 1. If the remainder turns out to be negative,
     *  we need to adjust it by adding 2 to make it non-negative. This adjustment ensures that the remainder
     * remains within the valid range of base -2, and we also need to compensate by modifying the quotient accordingly.
     */
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


}
