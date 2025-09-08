package AlgoMap.LinkedList;

import util.Node;
import util.SinglyLinkedList;

/* https://leetcode.com/problems/middle-of-the-linked-list/description/ */
public class MiddleOfLinkedList {

  public static void main(String[] args) {
    Node<Integer> n1 = new Node<Integer>(1, null);
    Node<Integer> n2 = new Node<Integer>(2, null);
    Node<Integer> n3 = new Node<Integer>(3, null);
    Node<Integer> n4 = new Node<Integer>(4, null);
    Node<Integer> n5 = new Node<Integer>(5, null);
    Node<Integer> n6 = new Node<Integer>(6, null);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);
    n5.setNext(n6);
    Node<Integer> finalNode = middleNode(n1);
    SinglyLinkedList.printList(finalNode);
  }

  static Node<Integer> middleNode(Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}