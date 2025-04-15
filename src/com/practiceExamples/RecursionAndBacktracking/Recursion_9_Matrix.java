package com.practiceExamples.RecursionAndBacktracking;

/*
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * https://www.youtube.com/watch?v=cPV3Jxw2NPU&list=PLQ7ZAf76c0ZMzC9OHPbo-dUgx6oU3T0jK&index=12
 * */
public class Recursion_9_Matrix {

  public static void main(String[] args) {
    int n = 1;
    int m = 3;
    System.out.println(
        "Number of paths from top-left to bottom-right in a " + n + "x" + m + " matrix : " + numberOfPaths(n, m));
  }

  private static int numberOfPaths(int row, int column) {
    if (row == 1 || column == 1) {
      //   System.out.println("row = " + row + ", column = " + column);
      return 1;
    }
    return numberOfPaths(row - 1, column) + numberOfPaths(row, column - 1);
  }
}
