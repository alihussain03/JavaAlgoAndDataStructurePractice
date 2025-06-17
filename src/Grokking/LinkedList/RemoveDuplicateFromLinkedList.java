package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/ */
public class RemoveDuplicateFromLinkedList {

  public static void main(String[] args) {

    Node<Integer> head = new Node<>(1, new Node<>(1, new Node<>(3, new Node<>(4, null))));

    System.out.println("Original List:");
    printList(head);

    System.out.println("After Removing Duplicates:");
    Node<Integer> reversedHead2 = removeDuplicatesFromTheList(head);
    printList(reversedHead2);
  }

  static Node<Integer> removeDuplicatesFromTheList(Node<Integer> head) {
    Node<Integer> current = head;
    while (current != null && current.next != null) {
      if (current.next.element == current.element) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }
}