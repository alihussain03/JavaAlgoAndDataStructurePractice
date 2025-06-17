package AlgoMaster.Array;

public class StockMaxProfit {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 6, 4, 3, 1, 8};
    System.out.println("Max profit is " + maxProfit(arr));
    System.out.println("Max profit is " + maxProfit2(arr));
  }

  /* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/ */
  static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int currentPrice : prices) {
      minPrice = Math.min(minPrice, currentPrice);
      maxProfit = Math.max(maxProfit, currentPrice - minPrice);
    }
    return maxProfit;
  }

  /* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/ */
  static int maxProfit2(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }
}