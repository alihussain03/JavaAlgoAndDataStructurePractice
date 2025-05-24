package AlgoMaster.LinkedList;

import util.Node;

/* https://leetcode.com/problems/linked-list-cycle-ii/description/ */
public class LinkedListCycle2 {

  public static void main(String[] args) {
    Node<Integer> node4 = new Node<>(4, null);
    Node<Integer> node3 = new Node<>(3, node4);
    Node<Integer> node2 = new Node<>(2, node3);
    Node<Integer> node1 = new Node<>(1, node2);

    // Create a cycle: node4 -> node2
    node4.next = node2;

    // Now node1 is the head of a cyclic list
    System.out.println(findCycle(node4));
  }

  static Node<Integer> findCycle(Node<Integer> head) {
    Node<Integer> fast = head;
    Node<Integer> slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow; // Start of the cycle
      }
    }
    return null; // No cycle
  }

}
