package AlgoMaster.HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.GeneralUtil;

/* https://leetcode.com/problems/group-anagrams/description/ */
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = groupAnagrams(input);
    System.out.println(lists);

    GeneralUtil.newFunctionCall();
    lists = groupAnagramsSpeedEfficient(input);
    System.out.println(lists);

  }

  static List<List<String>> groupAnagrams(String[] input) {
    if (input == null || input.length == 0) {
      return Collections.emptyList();
    }
    Map<String, List<String>> kk = new HashMap<>();
    for (String str : input) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      if (kk.containsKey(sorted)) {
        kk.get(sorted).add(str);
      } else {
        kk.put(sorted, new ArrayList<>(Collections.singleton(str)));
      }
    }
    return new ArrayList<>(kk.values());
  }

  static List<List<String>> groupAnagramsSpeedEfficient(String[] input) {
    if (input == null || input.length == 0) {
      return Collections.emptyList();
    }
    Map<String, List<String>> kk = new HashMap<>();
    for (String str : input) {
      String frequency = countFrequency(str);

      if (kk.containsKey(frequency)) {
        kk.get(frequency).add(str);
      } else {
        kk.put(frequency, new ArrayList<>(Collections.singleton(str)));
      }
    }
    return new ArrayList<>(kk.values());
  }

  static String countFrequency(String str) {
    if (str == null) {
      return null;
    }

    str = str.replaceAll("\\s", "").toLowerCase();

    int[] counts = new int[26];
    for (char c : str.toCharArray()) {
      counts[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    char ch = 'a';
    for (int count : counts) {
      sb.append(ch);
      sb.append(count);
      ch++;
    }
    return sb.toString();
  }
}