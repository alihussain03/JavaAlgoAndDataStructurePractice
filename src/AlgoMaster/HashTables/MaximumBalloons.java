package AlgoMaster.HashTables;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/maximum-number-of-balloons/description/
 * https://www.youtube.com/watch?v=fyST-_s97QU
 * */
public class MaximumBalloons {

  public static void main(String[] args) {
    System.out.println("Max Ballons are: " + maxNumberOfBalloons("loonbalxballpoon"));
  }

  static int maxNumberOfBalloons(String text) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : text.toCharArray()) {
      if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
        count.put(c, count.getOrDefault(c, 0) + 1);
      }
    }
    int x = Math.min(count.getOrDefault('b', 0), Math.min(count.getOrDefault('a', 0), count.getOrDefault('n', 0)));
    int xx = Math.min(count.getOrDefault('l', 0), count.getOrDefault('o', 0));

    return Math.min(xx / 2, x);
  }
}