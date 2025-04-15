package Grokking.Recursion.Easy;

public class SumOfNaturalNumber {

  public static void main(String[] args) {
    System.out.println("Sum of N natural nuber is: " + sumOfNaturalNumber(5));
  }

  public static int sumOfNaturalNumber(int N) {
    if (N <= 0) {
      return 0;
    }
    return N + sumOfNaturalNumber(N - 1);
  }
}
