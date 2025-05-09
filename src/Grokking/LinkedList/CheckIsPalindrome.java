package Grokking.LinkedList;

import util.Node;

public class CheckIsPalindrome {

  public static void main(String[] args) {
    Node<Integer> list = new Node<>(1, new Node<>(3, new Node<>(5, new Node<>(7, null))));
    System.out.println(isPalindrome(list));
  }

  static boolean isPalindrome(Node<Integer> head) {
    Node<Integer> tail = head;
    while (tail != null) {
      tail = tail.next;
    }
    while (head != tail) {
      if (head.element != tail.element) {
        head = head.next;
        //     tail=tail.pe
      }
    }
    return true;
  }

}
