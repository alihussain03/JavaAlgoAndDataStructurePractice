package Grokking.Recursion.Easy;

public class EuclidGCD {

  public static void main(String[] args) {
    int firstNumber = 12, secondNumber = 14;
    System.out.println("Using iterative method: " + usingIterativeMethod(firstNumber, secondNumber));
    System.out.println("Greatest common divisor of two numbers is: " + gcd(firstNumber, secondNumber));
  }

  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  /* https://www.youtube.com/watch?v=F2I2MQj6w7I&ab_channel=StardomEducation */
  static int usingIterativeMethod(int firstNumber, int secondNumber) {
    int remainder;
    while (secondNumber != 0) {
      remainder = firstNumber % secondNumber;
      firstNumber = secondNumber;
      secondNumber = remainder;
    }
    return firstNumber;
  }
}
