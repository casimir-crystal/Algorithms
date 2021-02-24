public class DoublyLinkedList<E> {
  private final Node<E> sentinelHead = new Node<>(null, null, null);
  private final Node<E> sentinelTail = new Node<>(null, null, null);
  private int size = 0; // number of nodes in the list

  public DoublyLinkedList() {
    sentinelHead.setNext(sentinelTail);
    sentinelTail.setPrevious(sentinelHead);
  }

  // access methods
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node<E> getFirst() {
    return sentinelHead.getNext();
  }

  public Node<E> getLast() {
    return sentinelTail.getPrevious();
  }

  // update methods
  public void addFirst(E e) { // adds element e to the front of the list
    addAfter(sentinelHead, e);
  }

  public void addLast(E e) { // adds element e to the front of the list
    addBefore(sentinelTail, e);
  }

  public void addAfter(Node<E> node, E e) { // adds element e to the front of the list
    node = new Node<>(e, node, node.getNext());
    node.getNext().setPrevious(node);
    node.getPrevious().setNext(node);
    size++;
  }

  public void addBefore(Node<E> node, E e) { // adds element e to the front of the list
    node = new Node<>(e, node.getPrevious(), node);
    node.getNext().setPrevious(node);
    node.getPrevious().setNext(node);
    size++;
  }

  public static class Node<E> {
    private final E element; // reference to the element stored at this node
    private Node<E> previous;
    private Node<E> next; // reference to the subsequent node in the list

    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      previous = p;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }

    public Node<E> getPrevious() {
      return previous;
    }

    public void setPrevious(Node<E> previous) {
      this.previous = previous;
    }
  }

  public String toString() {
    if (this.isEmpty()) return "";

    StringBuilder string = new StringBuilder();

    Node node = this.getFirst();
    string.append(node.getElement());

    while (node.getNext() != null && node.getNext().getNext() != null) {
      string.append(" <-> ");
      node = node.getNext();
      string.append(node.getElement());
    }

    return new String(string);
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    list.addFirst(20);
    list.addFirst(30);
    list.addLast(10);

    System.out.println(list.toString());
  }
}
