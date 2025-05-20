package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/partition-list/description/ */
public class PartitionList {

  public static void main(String[] args) {
    Node<Integer> list1 = new Node<>(1, new Node<>(4, new Node<>(3, new Node<>(2, null))));
    Node<Integer> listAfterSwappingNodes = partition(list1, 2);
    printList(listAfterSwappingNodes);
  }

  static Node<Integer> partition(Node<Integer> head, int x) {
    Node<Integer> lessHead = new Node<>(-1, null);
    Node<Integer> greaterHead = new Node<>(-1, null);
    Node<Integer> less = lessHead;
    Node<Integer> greater = greaterHead;

    while (head != null) {
      if (head.element < x) {
        less.next = head;
        less = less.next;
      } else {
        greater.next = head;
        greater = greater.next;
      }
      head = head.next;
    }
    greater.next = null;  // Important to avoid a cycle
    less.next = greaterHead.next;
    return lessHead.next;
  }
}
