package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/rotate-list/description/ */
public class RotateList {

  public static void main(String[] args) throws CloneNotSupportedException {
    Node<Integer> head = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, null))));

    System.out.println("Original List:");
    printList(head);

    System.out.println("Reversed List:");
    Node<Integer> reversedHead = rotate(head, 6);
    printList(reversedHead);

    System.out.println("Second list:");
    head = new Node<>(0, new Node<>(1, new Node<>(2, null)));
    System.out.println("Reversed List:");
    reversedHead = rotate(head, 1);
    printList(reversedHead);
  }

  public static Node<Integer> rotate(Node<Integer> head, int k) {
    Node<Integer> current = head;
    Node<Integer> tail = null;
    int size = 0;
    while (current != null) {
      tail = current;
      current = current.next;
      size++;
    }
    if (k % size == 0) {
      return head;
    }
    tail.next = head;
    Node<Integer> temp = head;
    for (int i = 0; i < size - k - 1; i++) {
      temp = temp.next;
    }
    head = temp.next;
    temp.next = null;
    return head;
  }
}