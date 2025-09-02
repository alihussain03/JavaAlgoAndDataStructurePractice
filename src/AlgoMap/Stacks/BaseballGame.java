package AlgoMap.Stacks;

import java.util.Stack;
import util.GeneralUtil;

/**
 * <a href="https://leetcode.com/problems/baseball-game/description/">LeetCode</a>
 */
public class BaseballGame {

  public static void main(String[] args) {
    System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    GeneralUtil.newFunctionCall();
    System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    GeneralUtil.newFunctionCall();
    System.out.println(calPoints(new String[]{"1", "C"}));
    GeneralUtil.newFunctionCall();
  }

  static int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    for (String operation : operations) {
      if (operation.equals("+")) {
        int last = stack.pop();
        int secondLast = stack.peek();
        int newScore = last + secondLast;
        stack.push(last);      // restore last
        stack.push(newScore);
      } else if (operation.equals("D")) {
        stack.push(stack.peek() * 2);
      } else if (operation.equals("C")) {
        stack.pop();
      } else { // number (positive or negative)
        stack.push(Integer.parseInt(operation));
      }
    }

    int sum = 0;
    for (int score : stack) {
      sum += score;
    }
    return sum;
  }
}