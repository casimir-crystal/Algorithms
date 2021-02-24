public class ExtendableArray<E> {
  private E[] arr;
  private int arraySize;

  ExtendableArray(int capacity) {
    arr = (E[]) new Object[capacity];
  }

  public void push(E element) {
    if (arraySize == arr.length) {
      extendSize(); // full of array; auto extends the size
    }

    arr[arraySize] = element;
    arraySize++;
  }

  public E[] getArr() {
    return arr;
  }

  public void extendSize() {
    // extend and copy
    E[] newArr = (E[]) new Object[arr.length * 2];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    // assign to instance array
    arr = newArr;
  }

  public String toString() {
    if (arraySize == 0) return "[]";

    StringBuilder string = new StringBuilder();

    string.append('[');
    for (int i=0; i < arraySize-1; i++) {
      string.append(arr[i]);
      string.append(", ");
    }

    string.append(arr[arraySize-1]); // append the last element
    string.append(']');

    return new String(string);
  }

  public static void main(String[] args) {
    ExtendableArray<Integer> array = new ExtendableArray<>(2);
    array.push(20);
    array.push(500);
//    array.push(10);
    System.out.println(array.toString());
  }
}
