package AlgoMap.BinarySearch;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 */
public class FindBadVersion {

  public static void main(String[] args) {
    System.out.println(firstBadVersion(5));
  }

  static int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      boolean isBad = isBadVersion(mid);
      if (isBad) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }

  static boolean isBadVersion(int n) {
    return n == 4;
  }
}