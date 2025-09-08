package AlgoMap.LinkedList;

/* <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">LeetCode</a> */

import util.Node;
import util.SinglyLinkedList;

public class MergeTwoLinkedList {

  public static void main(String[] args) {
    Node<Integer> l1 = new Node<Integer>(1, null);
    Node<Integer> l2 = new Node<Integer>(2, null);
    Node<Integer> l3 = new Node<Integer>(4, null);
    Node<Integer> l4 = new Node<Integer>(5, null);
    l1.setNext(l2);
    l2.setNext(l3);
    l3.setNext(l4);

    Node<Integer> n1 = new Node<Integer>(3, null);
    Node<Integer> n2 = new Node<Integer>(6, null);
    Node<Integer> n3 = new Node<Integer>(7, null);
    Node<Integer> n4 = new Node<Integer>(8, null);
    Node<Integer> n5 = new Node<Integer>(9, null);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);

    Node<Integer> finalNode = mergeTwoLists(l1, n1);
    SinglyLinkedList.printList(finalNode);
  }

  static Node<Integer> mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> dummy = new Node<>(-1, null);

    Node<Integer> head = dummy;
    while (list1 != null && list2 != null) {
      if (list1.getElement() > list2.getElement()) {
        head.setNext(list2);
        list2 = list2.getNext();
      } else if (list1.getElement() < list2.getElement()) {
        head.setNext(list1);
        list1 = list1.getNext();
      } else {
        head.setNext(list1);
        list1 = list1.getNext();
      }
      head = head.getNext();
    }

    if (list1 != null && list1.getNext() != null) {
      head.setNext(list1);
    } else {
      head.setNext(list2);
    }
    return dummy.getNext();
  }
}