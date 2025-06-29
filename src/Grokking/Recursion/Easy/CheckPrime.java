package Grokking.Recursion.Easy;

public class CheckPrime {

  public static void main(String[] args) {
    System.out.println("Is prime number using recursion : " + checkPrime(5));
    System.out.println("Is prime number using iteration : " + checkPrimeUsingIteration(5));
  }

  static boolean checkPrime(int number) {
    if (number < 2) {
      return false; // 0 and 1 are not prime numbers
    }
    if (number == 2) {
      return true; // 2 is the only even prime number
    }
    if (number % 2 == 0) {
      return false;
    }
    return checkDivisors(number, 3);
  }

  static boolean checkDivisors(int number, int divisor) {
    if (divisor * divisor > number) {
      return true; // Base case 3
    }
    if (number % divisor == 0) {
      return false; // Number is divisible, not prime
    }
    return checkDivisors(number, divisor + 2);
  }

  static boolean checkPrimeUsingIteration(int number) {
    if (number < 2) {
      return false;
    }
    if (number == 2) {
      return true;
    }
    if (number % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}