/**
 * A singly linked list implementation
 * with list swap and reverse functionality
 * @param <E>
 */
public class SinglyLinkedList<E> {
  private Node<E> head = null; // head node of the list (or null if empty)
  private Node<E> tail = null; // last node of the list (or null if empty)
  private int size = 0; // number of nodes in the list

  public SinglyLinkedList() {}

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

  private void swapHeadAndTail() {
    Node<E> temp = head;
    head = tail;
    tail = temp;
  }

  public Node<E> findNodeBefore(Node<E> target) {
    Node<E> node = this.getFirst();
    while (node != null) {
      if (node.getNext() == target) {
        return node;
      }
      node = node.getNext();
    }

    return null; // not find
  }

  public Node<E> findNodeByElement(E e) {
    Node<E> node = this.getFirst();
    while (node != null) {
      if (node.getElement() == e) {
        return node;
      }
      node = node.getNext();
    }

    return null; // not find
  }

  public static void printString(SinglyLinkedList<Integer> list) {
    if (list.isEmpty()) return;

    Node<Integer> node = list.getFirst();
    System.out.print(node.getElement());

    while (node.getNext() != null) {
      System.out.print(" -> ");
      node = node.getNext();
      System.out.print(node.getElement());
    }

    System.out.print("\n\n");
  }

  public void reverse() {
    Node<E> before = this.getFirst();
    Node<E> next = before.getNext(); // save the next reference
    before.setNext(null);

    while (next != null) {
      Node<E> node = next;
      next = node.getNext();

      node.setNext(before);
      before = node;
    }

    this.swapHeadAndTail();
  }

  public void swapNode(Node<E> x, Node<E> y) {
    // find and set the node's next which before x and y
    Node<E> beforeX = this.findNodeBefore(x);
    Node<E> beforeY = this.findNodeBefore(y);

    beforeX.setNext(y);
    beforeY.setNext(x);

    Node<E> temp = x.getNext(); // declare a temp node for swap usage
    x.setNext(y.getNext());
    y.setNext(temp);
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    for (int i=1; i <= 20; i++) {
      list.addLast(i); // set the LinkedList values as 1...20
    }

    System.out.println("The origin list:");
    SinglyLinkedList.printString(list);

    System.out.println("Let's swap node 5 and 15: ");
    Node<Integer> x = list.findNodeByElement(5);
    Node<Integer> y = list.findNodeByElement(15);
    list.swapNode(x, y);

    SinglyLinkedList.printString(list);

    System.out.println("Let's reverse the list:");
    list.reverse();

    SinglyLinkedList.printString(list);
  }
}
