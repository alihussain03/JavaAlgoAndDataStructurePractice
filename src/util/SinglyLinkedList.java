package util;

public class SinglyLinkedList<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SinglyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public static <T> void printList(Node<T> head) {
    Node<T> current = head;
    while (current != null) {
      System.out.print(current.element + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E first() {
    if (isEmpty()) {
      return null;
    }
    return head.getElement();
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }
    return tail.getElement();
  }

  public void addFirst(E e) {
    // head -> [e | next -> null] , tail -> null , size -> 0, when size is 0
    head = new Node<>(e, head);
    if (size == 0) {
      tail = head;
    }
    size++;
  }

  public E seondLast() {
    if (head == null || head.getNext() == null) {
      return null;
    }

    Node current = head, previous = null;
    while (current.getNext() != null) {
      previous = current;
      current = current.getNext();
    }
    return (E) previous.getElement();
  }

  public void addLast(E e) {
    Node<E> newest = new Node<>(e, null);
    if (isEmpty()) {
      head = newest;
    } else {
      tail.setNext(newest);
    }
    tail = newest;
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) {
      return null;
    }
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0) {
      tail = null; // crucial in maintaining the correct state of the linked list,
    }
    // particularly when the list becomes empty
    return answer;
  }

  public void printListUsingSize() {
    Node print = head;
    for (int i = 0; i < size; i++) {
      System.out.println(print.getElement());
      print = print.getNext();
    }
  }

  public int sizeExercise() {
    int count = 0;
    Node<E> walk = head;
    while (walk != null) {
      count++;
      walk = walk.getNext();
    }
    return count;
  }

  public boolean equals(Object O) {
    if (O == null) {
      return false;
    }
    if (getClass() != O.getClass()) {
      return false;
    }
    SinglyLinkedList other = (SinglyLinkedList) O;
    if (size != other.size()) {
      return false;
    }
    Node walkA = head;
    Node walkB = other.head;
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) {
        return false;
      }
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
    if (size > 0) {
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();
      Node<E> otherTail = other.head;
      while (walk != null) {
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }
}