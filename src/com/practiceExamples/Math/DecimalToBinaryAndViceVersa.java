package com.practiceExamples.Math;

import util.GeneralUtil;

public class DecimalToBinaryAndViceVersa {

  public static void main(String[] args) {

    System.out.println(decimalToBinary(10));
    GeneralUtil.newFunctionCall();
    System.out.println(binaryToDecimal("1010"));
  }

  static String decimalToBinary(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.insert(0, num % 2);
      num = num / 2;
    }
    return sb.toString();
  }

  static int binaryToDecimal(String binaryString) {
    int decimal = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      decimal = decimal * 2 + (binaryString.charAt(i) - '0');
    }
    return decimal;
  }
}
