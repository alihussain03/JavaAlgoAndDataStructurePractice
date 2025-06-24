package AlgoMaster.HashTables;

import java.util.HashMap;
import util.GeneralUtil;

/* https://leetcode.com/problems/ransom-note/ */
public class Ransom {

  public static void main(String[] args) {
    System.out.println(canConstruct("a", "b"));
    GeneralUtil.newFunctionCall();
    System.out.println(canConstruct("aa", "ab"));
    GeneralUtil.newFunctionCall();
    System.out.println(canConstruct("aa", "aab"));
    GeneralUtil.newFunctionCall();
  }

  static boolean canConstruct(String ransomNote, String magazine) {

    HashMap<Character, Integer> mapST = new HashMap<>();

    for (int i = 0; i < magazine.length(); i++) {
      char c1 = magazine.charAt(i);
      mapST.put(c1, mapST.getOrDefault(c1, 0) + 1);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char c1 = ransomNote.charAt(i);
      Integer count = mapST.get(c1);
      if (count == null || count <= 0) {
        return false;
      }
      mapST.put(c1, count - 1);
    }
    return true;
  }
}
