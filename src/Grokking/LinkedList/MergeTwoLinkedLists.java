package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=problem-list-v2&envId=linked-list */
public class MergeTwoLinkedLists {

  public static void main(String[] args) {

    Node<Integer> list1 = new Node<>(1, new Node<>(3, new Node<>(5, new Node<>(7, null))));
    Node<Integer> list2 = new Node<>(2, new Node<>(4, new Node<>(6, new Node<>(8, null))));

    Node<Integer> mergeList = mergeTwoLists(list1, list2);
    printList(mergeList);
  }

  static Node<Integer> mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> dummy = new Node<Integer>(-1, null);
    Node<Integer> current = dummy;
    while (list1 != null && list2 != null) {
      if (list1.element < list2.element) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      current = current.next;
    }
    if (list1 != null) {
      current.next = list1;
    } else {
      current.next = list2;
    }
    return dummy.next;
  }
}