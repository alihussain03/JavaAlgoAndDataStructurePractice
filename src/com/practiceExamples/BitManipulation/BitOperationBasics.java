package com.practiceExamples.BitManipulation;

import util.GeneralUtil;

public class BitOperationBasics {

  public static void main(String[] args) {
    swapNumbers(5, 6);
    GeneralUtil.newFunctionCall();

    System.out.println("isKthBitSet using left shift: " + isKthBitSetUsingLeftShift(7, 2));
    System.out.println("isKthBitSet using right shift: " + isKthBitSetUsingRightShift(7, 2));
    GeneralUtil.newFunctionCall();

    getIBit(9, 2);
    GeneralUtil.newFunctionCall();

    System.out.println("After setting i bit: " + setIBit(9, 2));
    GeneralUtil.newFunctionCall();

    System.out.println("after clearing i bit: " + clearIBit(13, 2));
    GeneralUtil.newFunctionCall();

    System.out.println("after toggle i bit: " + toggleIBit(13, 2));
    GeneralUtil.newFunctionCall();

    System.out.println("After removing last set bit: " + removeLastSetBit(13));
    GeneralUtil.newFunctionCall();

    System.out.println("is power of 2: " + isPowerOfTwo(32));
    GeneralUtil.newFunctionCall();

  }

  static void swapNumbers(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println("After swap value of A is: " + a);
    System.out.println("After swap value of B is: " + b);
  }

  // Checks if the k-th bit (0-indexed) is set using left shift
  // Example: n = 5 (0101), k = 2 → returns true
  static boolean isKthBitSetUsingLeftShift(int n, int k) {
    int mask = 1 << k;
    return (n & mask) != 0;
  }

  // Checks if the k-th bit (0-indexed) is set using right shift
  // Example: n = 5 (0101), k = 2 → returns true
  static boolean isKthBitSetUsingRightShift(int n, int k) {
    return ((n >> k) & 1) == 1;
  }

  // Prints the value of the k-th bit (0-indexed) of n
  // Example: n = 5 (0101), k = 1 → prints 0
  static void getIBit(int n, int k) {
    System.out.println("value of i bit is: " + ((n >> k) & 1));
  }

  // Sets the k-th bit (0-indexed) of n to 1
  // Example: n = 5 (0101), k = 1 → returns 7 (0111)
  static int setIBit(int n, int k) {
    return n | (1 << k);
  }

  // Clears the k-th bit (0-indexed) of n (sets it to 0)
  // Example: n = 5 (0101), k = 2 → returns 1 (0001)
  static int clearIBit(int n, int k) {
    return n & ~(1 << k);
  }

  // Toggles (flips) the k-th bit (0-indexed) of n
  // Example: n = 5 (0101), k = 0 → returns 4 (0100)
  static int toggleIBit(int n, int k) {
    return n ^ (1 << k);
  }

  // Removes the rightmost set bit (1) from n
  // Example: n = 12 (1100) → returns 8 (1000)
  static int removeLastSetBit(int n) {
    return n & (n - 1);
  }

  // Checks if n is a power of two (only one bit set)
  // Example: n = 8 (1000) → returns true; n = 10 (1010) → returns false
  static boolean isPowerOfTwo(int n) {
    return (n & (n - 1)) == 0;
  }
}