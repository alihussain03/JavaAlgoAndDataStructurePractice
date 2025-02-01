package com.practiceExamples.String;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class String_1_StringBasicOperations {
    public static void main(String[] args) {
        String str = "Reverse it without using any built in function";
        System.out.println("Reverse using for loop      : " + reverseStringUsingForLoop(str));
        System.out.println("Reverse using Recursion     : " + reverseStringUsingRecursion(str));
        System.out.println("Reverse using Builder class : " + reverseStringUsingBuilderClass(str));

        str = "Hello, World! How are you?";
        String delimiter = " ";
        System.out.println("String \"" + str + "\" split by delimiter \"" + delimiter + "\":");
        splitString(str, delimiter);
        System.out.println("String \"" + str + "\" converted to uppercase: " + convertToUpperCase(str));
        System.out.println("String \"" + str + "\" with removed whitespaces: " + removeWhiteSpaces(" 34324324 "));
        countWords(str);
        stringCompare("Hello", "hello");
        replaceCharacter("Hello", 'l', 'a');
        checkStringPrefix("Hello", "He");
        stringToChar("String to char and vice versa");
        removeCharacterFromString("Hello", 'l');
        stringToDateBasic("2021-09-01");
    }

    public static String reverseStringUsingForLoop(String input) {
        StringBuilder sb = new StringBuilder();
        // char[] chars = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringUsingRecursion(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return reverseStringUsingRecursion(input.substring(1)) + input.charAt(0);
    }

    public static String reverseStringUsingBuilderClass(String input) {
        if (input.isEmpty()) {
            return input;
        }
        return new StringBuilder(input).reverse().toString();
    }

    private static String convertToUpperCase(String str) {
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
        System.out.println("String \"" + str + "\" with replaced character \"" + oldChar + "\" with \"" + newChar + "\": " + str.replace(oldChar, newChar));
    }

    private static void checkStringPrefix(String str, String prefix) {
        System.out.println("String \"" + str + "\" starts with character \"" + prefix + "\": " + str.startsWith(prefix));
        System.out.println("String \"" + str + "\" ends with character \"" + prefix + "\": " + str.endsWith(prefix));
    }

    private static void stringToChar(String str) {
        char charArray[] = str.toCharArray();
        str = new String(charArray);
        System.out.println(str);
    }

    private static void removeCharacterFromString(String str, char ch) {

        System.out.println(str.replace(String.valueOf(ch), ""));

        removeCharacterFromStringUsingStreams(str, ch);
    }

    private static void removeCharacterFromStringUsingStreams(String str, char ch) {
        String result = str.chars().filter(c -> c != ch).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println("Using streams: " + result);
    }

    private static void stringToDateBasic(String str) {
        LocalDate localDate = LocalDate.parse(str);
        System.out.println(localDate.getMonth());
        System.out.println(localDate.toString());

        stringToDateAdvance(str);
    }

    private static void stringToDateAdvance(String str) {
        try {
            LocalDate localDate = LocalDate.parse(str);
            System.out.println("Parsed Date: " + localDate);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String customStr = "08/08/2024";
            LocalDate customDate = LocalDate.parse(customStr, formatter);
            System.out.println("Parsed Date with Custom Format: " + customDate);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format: " + str);
        }
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
}

