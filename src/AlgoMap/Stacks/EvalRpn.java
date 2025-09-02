package AlgoMap.Stacks;

import java.util.Stack;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">LeetCode</a>
 */
public class EvalRpn {

  public static void main(String[] args) {
    System.out.println(calPoints(new String[]{"2", "1", "+", "3", "*"}));
    GeneralUtil.newFunctionCall();
    System.out.println(calPoints(new String[]{"4", "13", "5", "/", "+"}));
  }

  static int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    for (String operation : operations) {
      if (operation.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (operation.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (operation.equals("/")) {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a / b);
      } else {
        stack.push(Integer.parseInt(operation));
      }
    }
    return stack.peek();
  }
}