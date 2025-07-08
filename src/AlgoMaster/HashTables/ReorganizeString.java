package AlgoMaster.HashTables;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/description/">...</a>
 */
public class ReorganizeString {

  static String reorganizeString(String str) {
    int[] frequency = new int[26];
    for (char c : str.toCharArray()) {
      frequency[c - 'a']++;
      if (frequency[c - 'a'] > ((str.length() + 1) / 2)) {
        return "";
      }
    }
    int max = 0, letter = 0;
    for (int i = 0; i < frequency.length; i++) {
      if (frequency[i] > max) {
        max = frequency[i];
        letter = i;
      }
    }

    char[] res = new char[str.length()];
    int index = 0;

    while (frequency[letter]-- > 0) {
      res[index] = (char) (letter + 'a');
      index += 2;
    }

    for (int i = 0; i < frequency.length; i++) {
      while (frequency[i]-- > 0) {
        if (index >= res.length) {
          index = 1;
        }
        res[index] = (char) (i + 'a');
        index += 2;
      }
    }
    return String.valueOf(res);
  }

  public static void main(String[] args) {
    System.out.println(reorganizeString("aab"));
  }
}