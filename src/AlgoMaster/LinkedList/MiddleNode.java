package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/middle-of-the-linked-list/description/ */
public class MiddleNode {

  public static void main(String[] args) {
    Node<Integer> list1 = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, null))));
    Node<Integer> listAfterSwappingNodes = middleNode(list1);
    printList(listAfterSwappingNodes);
  }

  static Node<Integer> middleNode(Node<Integer> head) {
    Node<Integer> slowPointer = head;
    Node<Integer> fastPointer = head;
    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    return slowPointer;
  }
}
