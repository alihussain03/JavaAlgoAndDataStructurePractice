package com.practice.String;

/**
 * Count the number of vowels and consonants in a string
 */
public class String_4_VowelsConsonantsCount {
    public static void main(String[] args) {
        String str = "Hello World!";
        int arr[] = countVowelsAndConsonants(str);
        System.out.println("Vowels count in \"" + str + "\" is: " + arr[0]);
        System.out.println("Consonants count in \"" + str + "\" is: " + arr[1]);
    }

    private static int[] countVowelsAndConsonants(String str) {
        if (str == null || str.isEmpty()) {
            return new int[]{0, 0};
        }
        int vowelsCount = 0;
        int consonantsCount = 0;
        String vowels = "aeiouAEIOU";

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) { // Check if the character is a letter
                if (vowels.indexOf(c) != -1) { // Check if the character is a vowel
                    vowelsCount++;
                } else { // Otherwise, it's a consonant
                    consonantsCount++;
                }
            }
        }
        return new int[]{vowelsCount, consonantsCount};
    }
}
