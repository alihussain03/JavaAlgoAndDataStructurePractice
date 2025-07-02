package AlgoMaster.HashTables;

import java.util.HashMap;
import java.util.Map;
import util.GeneralUtil;

/* https://leetcode.com/problems/maximum-number-of-balloons/description/
 * https://www.youtube.com/watch?v=fyST-_s97QU
 * */
public class MaximumBalloons {

  public static void main(String[] args) {
    System.out.println("Max Ballons are: " + maxNumberOfBalloons("loonbalxballpoon"));

    GeneralUtil.newFunctionCall();
    System.out.println("Max Ballons are: " + maxNumberOfBalloonsSpeedEfficient("loonbalxballpoon"));
  }

  static int maxNumberOfBalloons(String text) {
    Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
    for (char c : text.toCharArray()) {
      characterCount.put(c, characterCount.getOrDefault(c, 0) + ("balon".indexOf(c) >= 0 ? 1 : 0));
    }

    int numberOnce = Math.min(characterCount.getOrDefault('b', 0),
        Math.min(characterCount.getOrDefault('a', 0), characterCount.getOrDefault('n', 0)));

    int numberTwice = Math.min(characterCount.getOrDefault('l', 0), characterCount.getOrDefault('o', 0));

    return Math.min(numberTwice / 2, numberOnce);
  }

  static int maxNumberOfBalloonsSpeedEfficient(String text) {
    int b = 0, a = 0, l = 0, o = 0, n = 0;

    for (char ch : text.toCharArray()) {
      switch (ch) {
        case 'b':
          b++;
          break;
        case 'a':
          a++;
          break;
        case 'l':
          l++;
          break;
        case 'o':
          o++;
          break;
        case 'n':
          n++;
          break;
      }
    }

    // 'l' and 'o' appear twice in "balloon"
    l /= 2;
    o /= 2;

    // return minimum of all counts
    return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
  }
}