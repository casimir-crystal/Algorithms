public class SinglyLinkedListSwap<E> { //---------------- nested Node class ----------------
  private Node<E> head = null; // head node of the list (or null if empty)
  private Node<E> tail = null; // last node of the list (or null if empty)

  private int size = 0; // number of nodes in the list

  public SinglyLinkedListSwap() {
  } // constructs an initially empty list

  // access methods
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node<E> getFirst() {
    return head;
  }

  public Node<E> getLast() {
    return tail;
  }

  // update methods
  public void addFirst(E e) { // adds element e to the front of the list
    head = new Node<>(e, head); // create and link a new node
    if (size == 0)
      tail = head; // special case: new node becomes tail also
    size++;
  }

  public void addLast(E e) { // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null); // node will eventually be the tail
    if (isEmpty()) {
      head = newest; // special case: previously empty list
    } else {
      tail.setNext(newest); // new node after existing tail
    }
    tail = newest; // new node becomes the tail
    size++;
  }

  public static class Node<E> {
    private final E element; // reference to the element stored at this node
    private Node<E> next; // reference to the subsequent node in the list

    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> n) {
      next = n;
    }
  }

  public Node findNodeBefore(Node<E> target) {
    Node node = this.getFirst();
    while (node != null) {
      if (node.getNext() == target) {
        return node;
      }

      node = node.getNext();
    }

    return null; // not find
  }

  public Node findNodeByElement(E e) {
    Node node = this.getFirst();
    while (node != null) {
      if (node.getElement() == e) {
        return node;
      }

      node = node.getNext();
    }

    return null; // not find
  }

  public static void printString(SinglyLinkedListSwap list) {
    if (list.isEmpty()) return;

    Node node = list.getFirst();
    System.out.print(node.getElement());

    while (node.getNext() != null) {
      System.out.print(" -> ");
      node = node.getNext();
      System.out.print(node.getElement());
    }
  }

  public static void main(String[] args) {
    SinglyLinkedListSwap<Integer> list = new SinglyLinkedListSwap<Integer>();

    for (int i=1; i <= 20; i++) {
      list.addLast(i); // set the LinkedList values as 1...20
    }

    Node x = list.findNodeByElement(5);
    Node y = list.findNodeByElement(15);

    Node temp;

    temp = x.getNext();
    x.setNext(y.getNext());
    y.setNext(temp);

    Node beforeX = list.findNodeBefore(x);
    Node beforeY = list.findNodeBefore(y);

    beforeX.setNext(y);
    beforeY.setNext(x);

    SinglyLinkedListSwap.printString(list);
  }
}
