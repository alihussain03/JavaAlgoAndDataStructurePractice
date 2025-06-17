package com.practiceExamples.RecursionAndBacktracking;

/* https://leetcode.com/problems/convert-date-to-binary/ */
public class ConvertDateToBinary {

  public static void main(String[] args) {
    ConvertDateToBinary solution = new ConvertDateToBinary();
    System.out.println("Using Recursion");
    System.out.println(solution.convertDateToBinary("2080-02-29"));
    System.out.println("Efficient solution");
    System.out.println(solution.convertDateToBinaryEfficient("2080-02-29"));
  }

  public String convertDateToBinary(String date) {
    String[] parts = date.split("-");
    return convertDateToBinaryUsingRecursion(Integer.parseInt(parts[0])) + "-" + convertDateToBinaryUsingRecursion(
        Integer.parseInt(parts[1])) + "-" + convertDateToBinaryUsingRecursion(Integer.parseInt(parts[2]));
  }

  String convertDateToBinaryUsingRecursion(int num) {
    if (num == 0) {
      return "0";
    }
    if (num == 1) {
      return "1";
    }
    return convertDateToBinaryUsingRecursion(num / 2) + num % 2;
  }

  public String convertDateToBinaryEfficient(String date) {
    return efficientSolution(date);
  }

  //Using Java's built-in method
  public String efficientSolution(String date) {
    String[] parts = date.split("-");
    return Integer.toBinaryString(Integer.parseInt(parts[0])) + "-" + Integer.toBinaryString(Integer.parseInt(parts[1]))
        + "-" + Integer.toBinaryString(Integer.parseInt(parts[2]));
  }
}