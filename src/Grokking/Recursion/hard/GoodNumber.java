package Grokking.Recursion.hard;

public class GoodNumber {
    public static void main(String[] args) {
        boolean isGood = isValidNumberByCriteria("23478");
        System.out.println(isGood);
    }

    public static boolean isValidNumberByCriteria(String arg) {
        return isValidNumberByCriteria(arg, 0);
    }

    // A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime ((2, 3, 5, or 7).
    public static boolean isValidNumberByCriteria(String digits, int index) {
        if (index >= digits.length()) return true;
        char digit = digits.charAt(index);

        if ((index % 2 == 0 && (digit - '0') % 2 != 0) || (index % 2 != 0 && !isPrime(digit - '0'))) return false;
        return isValidNumberByCriteria(digits, index + 1);

    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i < num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
