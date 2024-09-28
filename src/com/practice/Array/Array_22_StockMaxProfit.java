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
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int currentPrice : prices) {
            minPrice = Math.min(minPrice, currentPrice);
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
        }
        return maxProfit;
    }
}
