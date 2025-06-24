package AlgoMaster.HashTables;

import java.util.HashMap;
import util.GeneralUtil;

/* https://leetcode.com/problems/isomorphic-strings/description/ */
public class Isomorphic {

  public static void main(String[] args) {
    System.out.println(isIsomorphic("ab", "cc"));
    GeneralUtil.newFunctionCall();
    System.out.println(isIsomorphic("foo", "bar"));
    GeneralUtil.newFunctionCall();
    System.out.println(isIsomorphic("egg", "add"));
  }

  static boolean isIsomorphic(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Character> mapST = new HashMap<>();
    HashMap<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);

      if (mapST.containsKey(c1)) {
        if (mapST.get(c1) != c2) {
          return false;
        }
      } else {
        if (mapTS.containsKey(c2)) {
          return false;
        }
        mapST.put(c1, c2);
        mapTS.put(c2, c1);
      }
    }
    return true;
  }
}