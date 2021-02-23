public class ExtendableArray {
  private int[] arr;
  private int arraySize;

  ExtendableArray(int capacity) {
    arr = new int[capacity];
  }

  public void push(int num) {
    if (arraySize == arr.length) {
      extendSize(); // full of array; auto extends the size
    }

    arr[arraySize] = num;
    arraySize++;
  }

  public int[] getArr() {
    return arr;
  }

  public void extendSize() {
    // extend and copy
    int[] newArr = new int[arr.length * 2];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    // assign to instance array
    arr = newArr;
  }
}
