package AlgoMap.LinkedList;

/* https://leetcode.com/problems/copy-list-with-random-pointer/description/ */
public class CopyLinkedList {

  public static void main(String[] args) {
    Node n1 = new Node(17);
    Node n2 = new Node(13);
    Node n3 = new Node(11);
    Node n4 = new Node(10);
    Node n5 = new Node(1);
    n1.next = n2;
    n2.next = n3;
    n2.random = n1;
    n3.next = n4;
    n3.random = n5;
    n4.next = n5;
    n4.random = n3;
    n5.random = n1;

    Node finalNode = copyRandomList(n1);
    printList(finalNode);
  }

  static Node copyRandomList(Node head) {
    Node curr = head;
    while (curr != null) {
      Node copy = new Node(curr.val);
      copy.next = curr.next;
      curr.next = copy;
      curr = curr.next.next;
    }

    curr = head;
    while (curr != null) {
      if (curr.random != null) {
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }

    curr = head;
    Node newHead = head.next;
    Node copyCurr = newHead;
    while (curr != null) {
      curr.next = copyCurr.next; // restore original
      curr = curr.next;
      if (curr != null) {
        copyCurr.next = curr.next; // link copy list
        copyCurr = copyCurr.next;
      }
    }
    return newHead;
  }

  static void printList(Node head) {
    Node current = head;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}