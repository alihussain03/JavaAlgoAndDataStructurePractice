package Grokking.Recursion.Easy;

public class PerfectSquare {

  public static void main(String[] args) {
    System.out.println("" + isPerfectSquare(17));
  }

  static boolean isPerfectSquare(int num) {
    return isPerfectSquareHelper(num, 0, num);
  }

  private static boolean isPerfectSquareHelper(int num, int low, int high) {
    if (low > high) {
      return false;
    }
    int mid = low + (high - low) / 2;
    if (mid * mid == num) {
      return true;
    } else if (mid * mid > num) {
      return isPerfectSquareHelper(num, low, high - 1);
    } else {
      return isPerfectSquareHelper(num, low + 1, high);
    }
  }
}
