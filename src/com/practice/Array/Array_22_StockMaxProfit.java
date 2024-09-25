package com.practice.Array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Array_22_StockMaxProfit {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 6, 4, 3, 1, 8};
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int j : prices) {
            minPrice = Math.min(minPrice, j);
            maxPro = Math.max(maxPro, j - minPrice);
        }
        return maxPro;
    }
}
