package AlgoMaster.LinkedList;

import static util.SinglyLinkedList.printList;
import java.util.HashSet;
import util.Node;

/* https://leetcode.com/problems/intersection-of-two-linked-lists/description/ */
public class IntersectionNodes {

  public static void main(String[] args) {
    Node<Integer> intersection = new Node<>(7, new Node<>(8, new Node<>(9, null)));

    Node<Integer> listA = new Node<>(1, new Node<>(2, new Node<>(3, intersection)));
    Node<Integer> listB = new Node<>(4, new Node<>(5, intersection));

    Node<Integer> result = getIntersectionNodeUsingTwoPointers(listA, listB);
    System.out.println("Two Pointers is optimal solution for this: ");
    printList(result);

    Node<Integer> result2 = getIntersectionNodeUsingHashSet(listA, listB);
    printList(result2);

  }

  static Node<Integer> getIntersectionNodeUsingTwoPointers(Node<Integer> headA, Node<Integer> headB) {
    if (headA == null || headB == null) {
      return null;
    }
    Node<Integer> pA = headA;
    Node<Integer> pB = headB;

    // Traverse both lists
    while (pA != pB) {
      // Move to the next node or switch lists when reaching the end
      pA = (pA != null) ? pA.next : headB;
      pB = (pB != null) ? pB.next : headA;
    }

    // Return the intersection node or null
    return pA;
  }

  static Node<Integer> getIntersectionNodeUsingHashSet(Node<Integer> headA, Node<Integer> headB) {
    if (headA == null || headB == null) {
      return null;
    }
    HashSet<Node<Integer>> visited = new HashSet<>();
    Node<Integer> currentA = headA;
    while (currentA != null) {
      visited.add(currentA);
      currentA = currentA.next;
    }

    Node<Integer> currentB = headB;
    while (currentB != null) {
      if (visited.contains(currentB)) {
        return currentB;  // Intersection found
      }
      currentB = currentB.next;
    }
    return null;
  }
}