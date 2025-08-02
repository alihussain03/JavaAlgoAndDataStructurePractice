package AlgoMap.ArrayAndString;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">LeetCode</a>
 */
public class BuyAndSellStock {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }

  static int maxProfit(int[] prices) {
    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;
    for (int currentPrice : prices) {
      minPrice = Math.min(minPrice, currentPrice);
      maxProfit = Math.max(maxProfit, currentPrice - minPrice);
    }
    return maxProfit;
  }
}
