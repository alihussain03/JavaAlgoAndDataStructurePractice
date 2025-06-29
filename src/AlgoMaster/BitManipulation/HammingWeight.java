package AlgoMaster.BitManipulation;

public class HammingWeight {

  public static void main(String[] args) {
    System.out.println(hammingWeight(11));
  }

  static int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }
}