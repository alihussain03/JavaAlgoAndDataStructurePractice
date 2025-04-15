package com.practiceExamples.String;

import java.util.HashMap;
import java.util.Map;

/**
 * find the first non-repeated character in a string
 */
public class String_3_NonRepeatedCharacter {

  public static void main(String[] args) {
    String str = "aabbcddeeff";
    Character result = findFirstNonRepeatedCharacter(str);
    System.out.println(str + "\" contains non repeated character: " + (result == null ? "No" : "Yes " + result));

    result = findFirstNonRepeatedCharacterUsingHashMap(str);
    System.out.println(str + "\" contains non repeated character: " + (result == null ? "No" : "Yes " + result));
  }

  public static Character findFirstNonRepeatedCharacter(String str) {
    if (str == null || str.isEmpty()) {
      return null; // Handle empty or null string
    }

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      boolean isUnique = true;
      for (int j = 0; j < str.length(); j++) {
        if (i != j && c == str.charAt(j)) {
          isUnique = false;
          break;
        }
      }
      if (isUnique) {
        return c;
      }
    }
    return null;
  }

  public static Character findFirstNonRepeatedCharacterUsingHashMap(String str) {
    if (str == null || str.isEmpty()) {
      return null;
    }

    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : str.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }

    for (char c : str.toCharArray()) {
      if (charCount.get(c) == 1) {
        return c;
      }
    }
    return null;
  }
}