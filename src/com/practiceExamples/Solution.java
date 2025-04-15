package com.practiceExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    //   System.out.println(calPoints(new String[]{"5", "2", "+", "C", "D", "+"}));
    int sum = calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}); //27
    System.out.println(sum);

    String input = "CCB";  // Example input
    int result = countUniqueSequences(input);
    System.out.println("Total number of unique subsequences: " + result);
  }

  static int calPoints(String[] ops) {

    List<String> list = new ArrayList<String>();
    for (String op : ops) {
      if (op.matches("-?\\d+")) {
        list.add(op);
      } else if (op.equals("+")) {
        if (list.size() > 1) {
          Integer k = Integer.parseInt(list.getLast()) + Integer.parseInt(list.get((list.size() - 2)));
          list.add(String.valueOf(k));
        }
      } else if (op.equals("C")) {
        list.removeLast();
      } else if (op.equals("D")) {
        int k = Integer.parseInt(list.getLast()) * 2;
        list.add(String.valueOf((k)));
      }
    }
    int sum = 0;
    for (String s : list) {
      sum += Integer.parseInt(s);
    }
    return sum;
  }


  // Function to generate all unique sequences
  public static void generateSequences(String s, String ans, HashSet<String> set) {
    if (!ans.isEmpty()) {
      set.add(ans);  // Add the non-empty sequence to the set
    }

    // Loop through all characters in the string
    for (int i = 0; i < s.length(); i++) {
      // Exclude the current character and find permutations of the rest of the string
      generateSequences(s.substring(0, i) + s.substring(i + 1), ans + s.charAt(i), set);
    }
  }

  // Main function to call the recursive function and return the count of unique sequences
  public static int countUniqueSequences(String s) {
    HashSet<String> uniqueSequences = new HashSet<>();  // To store unique sequences
    generateSequences(s, "", uniqueSequences);  // Generate all sequences
    return uniqueSequences.size();  // Return the size of the set, which is the count of unique sequences
  }


}
