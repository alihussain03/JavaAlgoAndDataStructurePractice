package Grokking.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

/* https://leetcode.com/problems/swap-nodes-in-pairs/description/ */
public class SwapNodes {

  public static void main(String[] args) {
    Node<Integer> list1 = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, null))));
    Node<Integer> listAfterSwappingNodes = swapNodes(list1);
    printList(listAfterSwappingNodes);
  }

  static Node<Integer> swapNodes(Node<Integer> head) {
    Node<Integer> dummy = new Node<Integer>(-1, null);
    dummy.next = head;
    Node<Integer> current = dummy;
    while (current.next != null && current.next.next != null) {
      Node<Integer> swap1 = current.next;
      Node<Integer> swap2 = current.next.next;

      swap1.next = swap2.next;
      swap2.next = swap1;

      // Prepare for next swap
      current.next = swap2;
      current = swap1;
    }
    return dummy.next;
  }
}