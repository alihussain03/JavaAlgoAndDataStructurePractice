package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;

import util.Node;

public class RemoveDuplicateFromLinkedList {

  public static void main(String[] args) {

    Node<Integer> head = new Node<>(1, new Node<>(1, new Node<>(3, new Node<>(4, null))));

    System.out.println("Original List:");
    printList(head);

    Node<Integer> reversedHead2 = removeDuplicatesFromTheList(head);
    printList(reversedHead2);

  }

  static Node<Integer> removeDuplicatesFromTheList(
      Node<Integer> head) {// Initialize the current node as the head of the list.
    Node<Integer> current = head;

    // Traverse through the list until the end is reached.
    while (current != null && current.next != null) {
      // If the next node is a duplicate, bypass it.
      if (current.next.element == current.element) {
        current.next = current.next.next;
      } else {
        // If not, move to the next node.
        current = current.next;
      }
    }
    // Return the modified head of the list.
    return head;
  }
}
