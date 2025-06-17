package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/reverse-linked-list/description/ */
public class ReverseLinkedList {

  public static void main(String[] args) throws CloneNotSupportedException {
    Node<Integer> head = new Node<>(1, new Node<>(1, new Node<>(3, new Node<>(4, null))));

    System.out.println("Original List:");
    printList(head);

    System.out.println("Reversed List:");
    Node<Integer> reversedHead = reverseList(head);
    printList(reversedHead);
  }

  public static Node<Integer> reverseList(Node<Integer> head) {
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