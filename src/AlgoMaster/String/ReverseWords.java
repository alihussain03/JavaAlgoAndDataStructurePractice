package AlgoMaster.String;

public class ReverseWords {

  /* https://leetcode.com/problems/reverse-words-in-a-string/description/ */
  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
    System.out.println(reverseWords("  hello world  "));
    System.out.println(reverseWords("a good   example"));
  }

  static String reverseWords(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    s = s.strip();
    String[] s1 = s.split(" +");
    for (int i = s1.length - 1; i >= 0; i--) {
      stringBuilder.append(s1[i]).append(" ");
    }
    return stringBuilder.toString().trim();
  }
}