package com.practice.String;

import java.util.*;

/**
 * Remove duplicates from a string
 */
public class String_6_RemoveDuplicates {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("String after removing duplicates: " + removeDuplicates(str));
        System.out.println("String after removing duplicates: " + removeDuplicatesUsingSet(str));
    }

    /**
     * Remove duplicates from a string using Hashmap
     * Problem with this approach is that the order of characters is not maintained. Order of characters in the
     * resulting string will be based on the insertion order in the HashMap, which is not guaranteed to be the
     * same as the order of their first appearance in the input string
     * <p>
     * Using a HashMap to count characters and then iterating over the entries to build the result string
     * involves more overhead than necessary. This approach also uses string concatenation in a loop
     * (result += entry.getKey();), which can be inefficient due to the creation of multiple intermediate String object
     */
    private static String removeDuplicates(String str) {
        char[] charArray = str.toCharArray();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : charArray) {
            if (!charCount.containsKey(c)) charCount.put(c, 1);
        }

        Iterator<Map.Entry<Character, Integer>> iterator = charCount.entrySet().iterator();
        String result = "";
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            result += entry.getKey();
        }
        return result;
    }

    // Efficient way
    private static String removeDuplicatesUsingSet(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty strings
        }

        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charSet) {
            sb.append(c);
        }
        return sb.toString();
    }
}
