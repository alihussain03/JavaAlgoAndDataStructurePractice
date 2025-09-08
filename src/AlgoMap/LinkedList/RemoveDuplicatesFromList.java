package AlgoMap.LinkedList;


import util.Node;
import util.SinglyLinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/">LeetCode</a>
 */
public class RemoveDuplicatesFromList {

  public static void main(String[] args) {
    Node<Integer> n1 = new Node<Integer>(1, null);
    Node<Integer> n2 = new Node<Integer>(2, null);
    Node<Integer> n3 = new Node<Integer>(2, null);
    Node<Integer> n4 = new Node<Integer>(3, null);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    Node<Integer> finalNode = deleteDuplicates(n1);
    SinglyLinkedList.printList(finalNode);
  }

  static Node<Integer> deleteDuplicates(Node<Integer> head) {
    Node<Integer> current = head;
    while (current != null && current.next != null) {
      if (current.element.equals(current.next.element)) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }
}