package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/ */
public class DeleteMiddleNode {

  public static void main(String[] args) {
    Node<Integer> list1 = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, null))));
    Node<Integer> listAfterSwappingNodes = middleNode(list1);
    printList(listAfterSwappingNodes);
  }

  static Node<Integer> middleNode(Node<Integer> head) {
    Node<Integer> slowPointer = head;
    Node<Integer> fastPointer = head;
    Node<Integer> prev = head;

    while (fastPointer != null && fastPointer.next != null) {
      prev = slowPointer;
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    // Remove the middle node
    if (prev != null) {
      prev.next = slowPointer.next;
    } else {
      // If there's only one node, deleting it means returning null
      head = head.next;
    }
    return head;
  }
}