package AlgoMap.Stacks;

import java.util.Stack;
import util.CollectionUtil;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/description/">LeetCode</a>
 */
public class DailyTemperatures {

  public static void main(String[] args) {
    CollectionUtil.printArray(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
  }

  static int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int n = temperatures.length;
    int[] res = new int[n];

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        res[stack.peek()] = i - stack.pop();
      }
      stack.push(i);
    }
    return res;
  }
}