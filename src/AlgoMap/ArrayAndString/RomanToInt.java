package AlgoMap.ArrayAndString;

import java.util.HashMap;
import java.util.Map;
import util.GeneralUtil;

/**
 * <a href=" https://https://leetcode.com/problems/roman-to-integer/description/">LeetCode</a>
 */
/**/
public class RomanToInt {

  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    GeneralUtil.newFunctionCall();
    System.out.println(romanToInt("LVIII"));
    GeneralUtil.newFunctionCall();
    System.out.println(romanToInt("MCMXCIV"));
    GeneralUtil.newFunctionCall();

    System.out.println("Second approach: ");
    System.out.println(romanToInt2("III"));
    GeneralUtil.newFunctionCall();
    System.out.println(romanToInt2("MCMXCIV"));
  }

  static int romanToInt(String s) {
    Map<Character, Integer> valueMap = new HashMap<>();
    valueMap.put('I', 1);
    valueMap.put('V', 5);
    valueMap.put('X', 10);
    valueMap.put('L', 50);
    valueMap.put('C', 100);
    valueMap.put('D', 500);
    valueMap.put('M', 1000);

    int value = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char currentCh = charArray[i];
      if (valueMap.containsKey(currentCh)) {
        if (currentCh == 'I' && i < charArray.length - 1 && charArray[i + 1] == 'V') {
          value += 4;
          i++;
        } else if (currentCh == 'I' && i < charArray.length - 1 && charArray[i + 1] == 'X') {
          value += 9;
          i++;
        } else if (currentCh == 'X' && i < charArray.length - 1 && charArray[i + 1] == 'L') {
          value += 40;
          i++;
        } else if (currentCh == 'X' && i < charArray.length - 1 && charArray[i + 1] == 'C') {
          value += 90;
          i++;
        } else if (currentCh == 'C' && i < charArray.length - 1 && charArray[i + 1] == 'D') {
          value += 400;
          i++;
        } else if (currentCh == 'C' && i < charArray.length - 1 && charArray[i + 1] == 'M') {
          value += 900;
          i++;
        } else {
          value += valueMap.get(currentCh);
        }
      }
    }
    return value;
  }

  static int romanToInt2(String s) {
    Map<Character, Integer> valueMap = new HashMap<>();
    valueMap.put('I', 1);
    valueMap.put('V', 5);
    valueMap.put('X', 10);
    valueMap.put('L', 50);
    valueMap.put('C', 100);
    valueMap.put('D', 500);
    valueMap.put('M', 1000);

    int total = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      int currentVal = valueMap.get(s.charAt(i));
      if (i < s.length() - 1 && currentVal < valueMap.get(s.charAt(i + 1))) {
        total -= currentVal;
      } else {
        total += currentVal;
      }
    }
    return total;
  }
}
