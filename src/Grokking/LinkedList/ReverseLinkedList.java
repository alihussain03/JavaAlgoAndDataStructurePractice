package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;

import util.Node;

public class ReverseLinkedList {

  public static void main(String[] args) throws CloneNotSupportedException {
    Node<Integer> head = new Node<>(1, new Node<>(1, new Node<>(3, new Node<>(4, null))));

    System.out.println("Original List:");
    printList(head);

    Node<Integer> reversedHead = reverseList(head);

    System.out.println("Reversed List:");
    printList(reversedHead);
  }

  /* https://leetcode.com/problems/reverse-linked-list/description/ */
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
