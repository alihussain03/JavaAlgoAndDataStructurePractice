package com.practice.String;

import java.util.HashMap;
import java.util.Map;

public class String_11_StringBasicOperations {
    public static void main(String[] args) {
        String str = "Hello, World! How are you?";
        String delimiter = " ";
        System.out.println("String \"" + str + "\" split by delimiter \"" + delimiter + "\":");
        splitString(str, delimiter);
        System.out.println("String \"" + str + "\" converted to uppercase: " + convertOutstrippingCase(str));
        System.out.println("String \"" + str + "\" with removed whitespaces: " + removeWhiteSpaces(" 34324324 "));
        countWords(str);
        stringCompare("Hello", "hello");
        replaceCharacter("Hello", 'l', 'a');
        checkStringPrefix("Hello", "He");
    }

    private static void splitString(String str, String delimiter) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String[] words = str.split(delimiter);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String convertOutstrippingCase(String str) {
        return str.toUpperCase();
    }

    private static String removeWhiteSpaces(String str) {
        return str.trim();
    }

    private static void countWords(String str) {
        System.out.println("Count of characters in \"" + str + "\": ");
        if (str == null || str.isEmpty()) {
            return;
        }

        char[] charArray = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : charArray) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println("Character: " + entry.getKey() + " Count: " + entry.getValue());
        }

    }

    private static void stringCompare(String str, String str1) {
        System.out.println("String \"" + str + "\" is equal to \"" + str1 + "\": " + str.equals(str1));
        System.out.println("String \"" + str + "\" is equal to \"" + str1 + "\": " + str.equalsIgnoreCase(str1));
        System.out.println("String \"" + str + "\" is equal to \"" + str1 + "\": " + str.compareTo(str1));
        System.out.println("String \"" + str + "\" is equal to \"" + str1 + "\": " + str.compareToIgnoreCase(str1));

    }

    private static void replaceCharacter(String str, char oldChar, char newChar) {
        System.out.println("String \"" + str + "\" with replaced character \"" + oldChar +
                "\" with \"" + newChar + "\": " + str.replace(oldChar, newChar));
    }

    private static void checkStringPrefix(String str, String prefix) {
        System.out.println("String \"" + str + "\" starts with character \"" + prefix + "\": " +
                str.startsWith(prefix));
        System.out.println("String \"" + str + "\" ends with character \"" + prefix + "\": " +
                str.endsWith(prefix));
    }


}
