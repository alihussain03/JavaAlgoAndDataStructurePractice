package Grokking.Recursion.Easy;

public class DecimalToBinary {

  public static void main(String[] args) {
    System.out.println("Decimal to binary using Recursion is " + decimalToBinary(13));
  }

  /*
    decimalToBinary(13)
    │
    ├── decimalToBinary(6)
    │   ├── decimalToBinary(3)
    │   │   ├── decimalToBinary(1) → "1"
    │   │   ├── Returns: "1" + "1" = "11"
    │   ├── Returns: "11" + "0" = "110"
    ├── Returns: "110" + "1" = "1101"
  */
  public static String decimalToBinary(int number) {
    if (number == 0) {
      return "0";
    }
    if (number == 1) {
      return "1";
    }
    return decimalToBinary(number / 2) + (number % 2);
  }
}
