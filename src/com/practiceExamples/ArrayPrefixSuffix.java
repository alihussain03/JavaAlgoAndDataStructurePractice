package com.practiceExamples;

import java.util.Arrays;

public class ArrayPrefixSuffix {

  // ========== 1D Arrays ==========

  // Prefix Sum 1D
  public static int[] prefixSum1D(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    prefix[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }
    return prefix;
  }

  // Suffix Sum 1D
  public static int[] suffixSum1D(int[] nums) {
    int n = nums.length;
    int[] suffix = new int[n];
    suffix[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] + nums[i];
    }
    return suffix;
  }

  // Prefix Product 1D
  public static long[] prefixProduct1D(int[] nums) {
    int n = nums.length;
    long[] prefixProd = new long[n];
    prefixProd[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefixProd[i] = prefixProd[i - 1] * nums[i];
    }
    return prefixProd;
  }

  // Suffix Product 1D
  public static long[] suffixProduct1D(int[] nums) {
    int n = nums.length;
    long[] suffixProd = new long[n];
    suffixProd[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suffixProd[i] = suffixProd[i + 1] * nums[i];
    }
    return suffixProd;
  }

  // ========== 2D Arrays ==========

  // Prefix Sum 2D
  public static int[][] prefixSum2D(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] prefix = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int left = (j > 0) ? prefix[i][j - 1] : 0;
        int up = (i > 0) ? prefix[i - 1][j] : 0;
        int diag = (i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0;
        prefix[i][j] = matrix[i][j] + left + up - diag;
      }
    }
    return prefix;
  }

  // Suffix Sum 2D
  public static int[][] suffixSum2D(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] suffix = new int[rows][cols];

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        int right = (j < cols - 1) ? suffix[i][j + 1] : 0;
        int down = (i < rows - 1) ? suffix[i + 1][j] : 0;
        int diag = (i < rows - 1 && j < cols - 1) ? suffix[i + 1][j + 1] : 0;
        suffix[i][j] = matrix[i][j] + right + down - diag;
      }
    }
    return suffix;
  }

  // Prefix Product 2D
  public static long[][] prefixProduct2D(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    long[][] prefixProd = new long[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        long left = (j > 0) ? prefixProd[i][j - 1] : 1;
        long up = (i > 0) ? prefixProd[i - 1][j] : 1;
        long diag = (i > 0 && j > 0) ? prefixProd[i - 1][j - 1] : 1;
        prefixProd[i][j] = matrix[i][j] * left * up / diag;  // Using inclusion-exclusion multiplication
      }
    }
    return prefixProd;
  }

  // Suffix Product 2D
  public static long[][] suffixProduct2D(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    long[][] suffixProd = new long[rows][cols];

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        long right = (j < cols - 1) ? suffixProd[i][j + 1] : 1;
        long down = (i < rows - 1) ? suffixProd[i + 1][j] : 1;
        long diag = (i < rows - 1 && j < cols - 1) ? suffixProd[i + 1][j + 1] : 1;
        suffixProd[i][j] = matrix[i][j] * right * down / diag;  // Inclusion-exclusion for product
      }
    }
    return suffixProd;
  }

  // ----------- Testing helper -----------

  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static void printArray(long[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static void printMatrix(int[][] mat) {
    for (int[] row : mat) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void printMatrix(long[][] mat) {
    for (long[] row : mat) {
      System.out.println(Arrays.toString(row));
    }
  }

  // ========== Main method to test ==========
  public static void main(String[] args) {
    int[] nums = {2, 3, 4};
    System.out.println("Prefix Sum 1D:");
    printArray(prefixSum1D(nums));

    System.out.println("Suffix Sum 1D:");
    printArray(suffixSum1D(nums));

    System.out.println("Prefix Product 1D:");
    printArray(prefixProduct1D(nums));

    System.out.println("Suffix Product 1D:");
    printArray(suffixProduct1D(nums));

    int[][] matrix = {
        {1, 2},
        {3, 4}
    };

    System.out.println("\nPrefix Sum 2D:");
    printMatrix(prefixSum2D(matrix));

    System.out.println("Suffix Sum 2D:");
    printMatrix(suffixSum2D(matrix));

    System.out.println("Prefix Product 2D:");
    printMatrix(prefixProduct2D(matrix));

    System.out.println("Suffix Product 2D:");
    printMatrix(suffixProduct2D(matrix));
  }
}

