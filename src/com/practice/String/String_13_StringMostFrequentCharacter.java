package com.practice.String;

import java.util.HashMap;
import java.util.Map;

public class String_13_StringMostFrequentCharacter {
    public static void main(String[] args) {
        String str = "Hello World!";
        System.out.println("Most frequent character in \"" + str + "\" is: " + mostFrequentCharacter(str));
        System.out.println("Most frequent character in \"" + str + "\" is: " + mostFrequentCharacterUsingHashmap(str));
    }

    private static String mostFrequentCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int[] count = new int[256];
        for (char c : str.toCharArray()) {
            count[c]++;
        }
        int max = -1;
        char result = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) i;
            }
        }
        return String.valueOf(result);
    }

    private static char mostFrequentCharacterUsingHashmap(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        char mostFrequentChar = str.charAt(0);
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }
        return mostFrequentChar;
    }
}
