package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/reverse-linked-list-ii/description/ */
public class ReverseLinkedList2 {

  public static void main(String[] args) throws CloneNotSupportedException {
    Node<Integer> head = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));

    System.out.println("Original List:");
    printList(head);

    System.out.println("Reversed List:");
    Node<Integer> reversedHead = reverseList(head, 2, 4);
    printList(reversedHead);
  }

  public static Node<Integer> reverseList(Node<Integer> head, int left, int right) {
    if (head == null || left == right) {
      return head;
    }

    Node<Integer> dummy = new Node<>(0, null);
    dummy.next = head;
    Node<Integer> prev = dummy;

    for (int i = 1; i < left; i++) {
      prev = prev.next;
    }

    Node<Integer> current = prev.next;
    for (int i = 0; i < right - left; i++) {
      Node<Integer> temp = current.next;
      current.next = temp.next;
      temp.next = prev.next;
      prev.next = temp;
    }

    return dummy.next;
  }
}