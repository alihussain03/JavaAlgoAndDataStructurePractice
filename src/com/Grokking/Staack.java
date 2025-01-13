package com.Grokking;

import java.util.Stack;

public class Staack {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));

    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (c == '}' && last != '{') return false;
                else if (c == ']' && last != '[') return false;
                else if (c == ')' && last != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}
