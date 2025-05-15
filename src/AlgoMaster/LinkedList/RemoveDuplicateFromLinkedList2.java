package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import util.Node;

public class RemoveDuplicateFromLinkedList2 {

  public static void main(String[] args) {

    Node<Integer> head = new Node<>(1, new Node<>(1, new Node<>(2, null)));

    System.out.println("Original List:");
    printList(head);

    System.out.println("After Removing Duplicates:");
    Node<Integer> reversedHead2 = removeDuplicatesFromTheList(head);
    printList(reversedHead2);
  }

  static Node<Integer> removeDuplicatesFromTheList(Node<Integer> head) {
    Node<Integer> dummy = new Node<>(-1, null);

    Node<Integer> previousNode = dummy;
    Node<Integer> currentNode = head;

    while (currentNode != null) {
      if (currentNode.next != null && currentNode.element == currentNode.next.element) {
        while (currentNode.next != null && currentNode.element == currentNode.next.element) {
          currentNode = currentNode.next;
        }
        previousNode.next = currentNode.next;
      } else {
        previousNode = previousNode.next;
      }
      currentNode = currentNode.next;
    }
    return dummy.next;
  }
}