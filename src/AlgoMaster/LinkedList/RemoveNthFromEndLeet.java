package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/ */
public class RemoveNthFromEndLeet {

  public static void main(String[] args) {
    Node<Integer> head = new Node<>(7, new Node<>(8, new Node<>(9, null)));
    printList(removeNthFromEnd(head, 2));
  }

  static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
    Node<Integer> dummy = new Node<>(-1, null);
    dummy.next = head;

    Node<Integer> firstPointer = dummy;
    Node<Integer> secondPointer = dummy;

    for (int i = 0; i < n; i++) {
      secondPointer = secondPointer.next;
    }
    while (secondPointer.next != null) {
      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next;
    }

    firstPointer.next = firstPointer.next.next;
    return dummy.next;
  }
}
