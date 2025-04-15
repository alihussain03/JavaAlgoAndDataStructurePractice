package Grokking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queuee {

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    System.out.println(reverseQueue(queue));
  }

  static Queue<Integer> reverseQueue(Queue<Integer> q) {
    Stack<Integer> stack = new Stack<>();
    while (!q.isEmpty()) {
      stack.add(q.peek());
      q.remove();
    }
    while (!stack.isEmpty()) {
      q.add(stack.peek());
      stack.pop();
    }
    return q;
  }
}
