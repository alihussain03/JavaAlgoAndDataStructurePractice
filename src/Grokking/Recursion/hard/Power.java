package Grokking.Recursion.hard;

public class Power {

  public static void main(String[] args) {
    int a = 2, n = 5;
    int power = 1;

    System.out.println("Using while Loop: " + calculatePowerUsingWhileLoop(a, n, power));

    int k = calculatePowerUsingRecursion(a, n);
    System.out.println("Recursive Recursion: " + k);

    System.out.println("Efficient solution: " + calculatePower(2, 5));
  }

  static int calculatePowerUsingWhileLoop(int a, int n, int power) {
    for (int i = 0; i < n; i++) {
      power *= a;
    }
    return power;
  }

  static int calculatePowerUsingRecursion(int a, int n) {
    if (n == 0) {
      return 1;
    }
    return a * calculatePowerUsingRecursion(a, n - 1);
  }

  // Grokking solution
  public static double calculatePower(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 1 / calculatePower(x, -n);
    }
    double temp = calculatePower(x, n / 2);
    if (n % 2 == 0) {
      return temp * temp;
    } else {
      return x * temp * temp;
    }
  }
}
