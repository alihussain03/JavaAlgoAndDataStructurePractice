package Grokking.Recursion.Medium;

class ListNode {

  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
  }
}

public class LinkedList {

  public static ListNode removeNodes(ListNode head, int target) {
    if (head == null) {
      return null;
    }

    // Recursively process the rest of the list
    head.next = removeNodes(head.next, target);

    // If current node needs to be removed, return next node
    return head.val == target ? head.next : head;
  }

  public static void printLinkedList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Example 1
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(4);
    head1.next.next.next.next = new ListNode(2);

    System.out.print("Original Linked List 1: ");
    printLinkedList(head1);

    // Remove nodes with value 2 from linked list
    ListNode modifiedHead1 = removeNodes(head1, 2);
    System.out.print("Modified Linked List 1: ");
    printLinkedList(modifiedHead1);
  }
}
