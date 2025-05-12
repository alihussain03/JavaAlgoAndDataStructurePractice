package Grokking.LinkedList;

import util.Node;

/* https://leetcode.com/problems/palindrome-linked-list/description/ */
public class CheckIsPalindrome {

  public static void main(String[] args) {
    Node<Integer> list = new Node<>(1, new Node<>(3, new Node<>(3, new Node<>(1, null))));
    System.out.println(isPalindrome(list));
  }

  static boolean isPalindrome(Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast != null) {
      slow = slow.next;
    }
    slow = ReverseLinkedList.reverseList(slow);
    fast = head;
    while (slow != null) {
      if (fast.element != slow.element) {
        return false;
      }
      fast = fast.next;
      slow = slow.next;
    }
    return true;
  }

}
