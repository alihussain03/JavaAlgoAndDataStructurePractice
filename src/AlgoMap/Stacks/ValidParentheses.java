package AlgoMap.Stacks;

import java.util.Stack;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">LeetCode</a>
 */
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    GeneralUtil.newFunctionCall();
    System.out.println(isValid("()[]{}"));
    GeneralUtil.newFunctionCall();
    System.out.println(isValid("(]"));
    GeneralUtil.newFunctionCall();
    System.out.println(isValid("([])"));
    GeneralUtil.newFunctionCall();
  }

  static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (c == ')' || c == '}' || c == ']') {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}