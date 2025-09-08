package AlgoMap.LinkedList;

import util.Node;
import util.SinglyLinkedList;

/* https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/ */
public class RemoveNodeFromLinkedList {

  public static void main(String[] args) {
    Node<Integer> n1 = new Node<Integer>(1, null);
    Node<Integer> n2 = new Node<Integer>(2, null);
    Node<Integer> n3 = new Node<Integer>(3, null);
    Node<Integer> n4 = new Node<Integer>(4, null);
    Node<Integer> n5 = new Node<Integer>(5, null);

    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);

    Node<Integer> finalNode = removeNthFromEnd(n1, 2);
    SinglyLinkedList.printList(finalNode);
  }

  static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
    Node<Integer> dummy = new Node<>(-1, head);
    Node<Integer> slow = dummy;
    Node<Integer> fast = dummy;

    for (int i = 0; i < n && fast != null; i++) {
      fast = fast.next;
    }

    while (fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext();
    }
    slow.next = slow.getNext().getNext();
    return dummy.next;
  }
}