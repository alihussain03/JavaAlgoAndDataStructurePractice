package Grokking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Staack {

  public static void main(String[] args) {
    String s = "()";
    System.out.println("Is expression is valid: " + isValid(s));
    System.out.println("Reverse the string: " + reverseString("Hello"));
    System.out.println("Decimal to binary : " + decimalToBinary(2));
    System.out.println("Next larger element: " + nextLargerElement(List.of(4, 5, 2, 10)));
    Stack<Integer> input = new Stack<>();
    input.push(5);
    input.push(4);
    input.push(10);
    input.push(2);
    input.push(1);
    System.out.println("Stack after sort: " + sortStack(input));
    System.out.println("Stack after simplify path: " + simplifyPath("/../")); //"/a//b///c/d//././/..."
    System.out.println("Stack after removing the duplicates: " + removeDuplicates("abbaca"));
    System.out.println("Stack after removing the stars: " + removeStars("*a*b*c"));
    System.out.println("Stack after removing the alphabetic: " + removeAlphabetic("AaBbCcDdEeff"));
  }

  static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char last = stack.pop();
        if (c == '}' && last != '{') {
          return false;
        } else if (c == ']' && last != '[') {
          return false;
        } else if (c == ')' && last != '(') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  static String reverseString(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      stack.push(c);
    }
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty()) {
      reversed.append(stack.pop());
    }
    return reversed.toString();
  }

  static String decimalToBinary(int num) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      stack.push(num % 2);
      num = num / 2;
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  // The Next Greater Element for an element x is the first greater element on the right side of x in the array.
  static List<Integer> nextLargerElement(List<Integer> arr) {
    List<Integer> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = arr.size() - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr.get(i)) {
        stack.pop();
      }
      res.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(arr.get(i));
    }
    Collections.reverse(res);
    return res;
  }

  static Stack<Integer> sortStack(Stack<Integer> input) {
    Stack<Integer> tmpStack = new Stack<>();
    while (!input.isEmpty()) {
      int tmp = input.pop();
      while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
        input.push(tmpStack.pop());
      }
      tmpStack.push(tmp);
    }
    return tmpStack;
  }

  // simplify it by converting ".." to the previous directory and removing any "." or multiple slashes.
  static String simplifyPath(String path) {
    StringBuilder result = new StringBuilder();
    Stack<String> stack = new Stack<>();
    for (String s : path.split("/")) {
      if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!s.isEmpty() && !s.equals(".")) {
        stack.push(s);
      }
    }
    for (String dir : stack) {
      result.append("/");
      result.append(dir);
    }
    return result.length() == 0 ? "/" : result.toString();
  }

  // A string is considered valid if it does not have any two adjacent duplicate characters.
  static String removeDuplicates(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (!stack.isEmpty() && c == stack.peek()) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  //Given a string s, where * represents a star. We can remove a star along with its closest non-star character to its left in a single operation.
  // "abc*de*f" -> "abdf"
  static String removeStars(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (!stack.isEmpty() && c == '*') {
        stack.pop();
      } else if (c != '*') {
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  static String removeAlphabetic(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (!stack.empty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(c) && !stack.peek()
          .equals(c)) {
        stack.pop();
      } else {
        stack.push(c);
      }

    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }
}