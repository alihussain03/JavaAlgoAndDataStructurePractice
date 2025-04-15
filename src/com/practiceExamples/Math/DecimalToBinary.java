package com.practiceExamples.Math;

public class DecimalToBinary {

  public static void main(String[] args) {
    System.out.println(decimalToBinary(10));
  }

  static String decimalToBinary(int n) {
    StringBuilder binary = new StringBuilder();
    while (n > 0) {
      binary.insert(0, n % 2);
      n = n / 2;
    }
    return binary.toString();
  }
}
