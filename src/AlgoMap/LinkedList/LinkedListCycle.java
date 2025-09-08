package AlgoMap.LinkedList;

/* <a href="https://leetcode.com/problems/linked-list-cycle/description/">LeetCode</a> */

import java.util.HashSet;
import util.Node;

public class LinkedListCycle {

  public static void main(String[] args) {
    Node<Integer> l1 = new Node<Integer>(3, null);
    Node<Integer> l2 = new Node<Integer>(2, null);
    Node<Integer> l3 = new Node<Integer>(0, null);
    Node<Integer> l4 = new Node<Integer>(4, null);
    l1.setNext(l2);
    l2.setNext(l3);
    l3.setNext(l4);
    l4.setNext(l2);
    System.out.println(hasCycle(l1));
  }

  // Acceptable
  static public boolean hasCycle(Node<Integer> head) {
    HashSet<Node> hashSet = new HashSet<>();
    while (head != null) {
      if (hashSet.contains(head)) {
        return true;
      }
      hashSet.add(head);
      head = head.getNext();
    }
    return false;
  }

  //More Fast
  static public boolean hasCycleFloyds(Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
