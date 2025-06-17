package AlgoMaster.LinkedList;

/* https://leetcode.com/problems/copy-list-with-random-pointer/ */
public class CopyListWithRandomNumber {

  public static void main(String[] args) {
    Node head = new Node(0);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    head.next = n1;
    head.random = n3;
    n1.next = n2;
    n1.random = head;
    n2.next = n3;
    n2.random = n1;
    n3.next = null;
    n3.random = n2;
    Node copyNode = copyRandomList(head);
    System.out.println("List after copy");
    while (copyNode != null) {
      System.out.print(copyNode.val + " -> ");
      copyNode = copyNode.next;
    }
  }

  static Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // Step 1: Interweaving copied nodes with original nodes
    Node current = head;
    while (current != null) {
      Node copy = new Node(current.val);
      copy.next = current.next;
      current.next = copy;
      current = copy.next;
    }

    // Step 2: Assign random pointers to copied nodes
    current = head;
    while (current != null) {
      if (current.random != null) {
        current.next.random = current.random.next;
      }
      current = current.next.next;
    }

    // Step 3: Separate the copied list from the original list
    current = head;
    Node copyHead = head.next;
    Node copyCurrent = copyHead;

    while (current != null) {
      current.next = current.next.next;
      if (copyCurrent.next != null) {
        copyCurrent.next = copyCurrent.next.next;
      }
      current = current.next;
      copyCurrent = copyCurrent.next;
    }

    return copyHead;
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