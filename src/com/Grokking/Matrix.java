package com.Grokking;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] accounts = {{5, 2, 3}, {0, 6, 7}};
        System.out.println("Maximum Wealth: " + maximumWealth(accounts));
        System.out.println("Diagonal Sum: " + diagonalSum(accounts));
        System.out.println("Max Ones Row: " + Arrays.toString(findMaxOnesRow(new int[][]{{1, 0}, {1, 1}, {0, 1}})));
    }

    static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customers : accounts) {
            int wealth = 0;
            for (int customer : customers) {
                wealth += customer;
            }
            maxWealth = Math.max(wealth, maxWealth);
        }
        return maxWealth;
    }

    static int diagonalSum(int[][] mat) {
        int totalSum = 0;
        int n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            totalSum += mat[i][i] + mat[i][n - i - 1];
        }
        if (n % 2 != 0) {
            totalSum -= mat[n / 2][n / 2];
        }
        return totalSum;
    }

    static int[] findMaxOnesRow(int[][] mat) {
        int maxOnesCount = 0;
        int maxOnesIdx = 0;
        for (int i = 0; i < mat.length; i++) {
            int onesCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                onesCount += mat[i][j];
            }

            if (onesCount > maxOnesCount) {
                maxOnesIdx = i;
                maxOnesCount = onesCount;
            }
        }
        return new int[]{maxOnesIdx, maxOnesCount};
    }
}
