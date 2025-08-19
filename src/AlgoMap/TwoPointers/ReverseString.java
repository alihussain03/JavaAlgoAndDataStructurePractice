package AlgoMap.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">LeetCode</a>
 */
public class ReverseString {

  public static void main(String[] args) {
    reverseString(new char[]{'h', 'e', 'l', 'l', 'o' });
  }

  static void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;

    while (left < right) {
      char temp = s[right];
      s[right] = s[left];
      s[left] = temp;
      right--;
      left++;
    }
  }
}