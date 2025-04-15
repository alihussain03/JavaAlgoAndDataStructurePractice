package com.practiceExamples.String;

import java.util.Arrays;

/**
 * Check if two strings are anagrams of each other Two strings are anagrams if they contain the same characters with the
 * same frequency, but the order of characters may differ. For example, "listen" and "silent" are anagrams.
 */
public class String_5_StringAnagram {

  public static void main(String[] args) {
    String str1 = "listen";
    String str2 = "silent";
    System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams: " + areAnagrams(str1, str2));
  }

  private static boolean areAnagrams(String str1, String str2) {
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      return false;
    }

    str1 = str1.replaceAll("\\s", "").toLowerCase();
    str2 = str2.replaceAll("\\s", "").toLowerCase();

    // Convert strings to char arrays and sort
    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();
    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    // Compare sorted arrays
    return Arrays.equals(charArray1, charArray2);


  }
}
