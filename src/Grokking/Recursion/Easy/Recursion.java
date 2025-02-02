package Grokking.Recursion.Easy;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Sum of N natural nuber is: " + sumOfNaturalNumber(1));
        System.out.println("Factorial is: " + calculateFactorial(5));
        System.out.println("Greatest common divisor of two numbers is: " + gcd(12, 14));
    }

    public static int sumOfNaturalNumber(int N) {
        if (N <= 0) return 0;
        return N + sumOfNaturalNumber(N - 1);
    }

    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) return 1;
        return number * calculateFactorial(number - 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
