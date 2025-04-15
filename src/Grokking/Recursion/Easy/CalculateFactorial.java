package Grokking.Recursion.Easy;

public class CalculateFactorial {

  public static void main(String[] args) {
    System.out.println("Factorial is: " + calculateFactorial(5));
  }

  public static int calculateFactorial(int number) {
    if (number == 0 || number == 1) {
      return 1;
    }
    return number * calculateFactorial(number - 1);
  }
}
