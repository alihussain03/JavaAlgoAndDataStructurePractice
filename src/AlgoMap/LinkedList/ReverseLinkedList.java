package AlgoMap.LinkedList;

import util.Node;
import util.SinglyLinkedList;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">LeetCode</a>
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
    Node<Integer> n1 = new Node<Integer>(1, null);
    Node<Integer> n2 = new Node<Integer>(2, null);
    Node<Integer> n3 = new Node<Integer>(3, null);
    Node<Integer> n4 = new Node<Integer>(4, null);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    Node<Integer> finalNode = reverseList(n1);
    SinglyLinkedList.printList(finalNode);
  }

  static Node<Integer> reverseList(Node<Integer> head) {
    Node<Integer> current = head;
    Node<Integer> prev = null;

    while (current != null) {
      Node<Integer> next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}