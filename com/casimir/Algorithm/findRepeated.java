/**
 * Find and print the first repeated number in an array of integers L
 * where L's length equals n, and numbers in range [1...n]
 */
public class findRepeated {
  public static int find(int[] arr) {
    int[] bucket = new int[arr.length+1];

    for (int i : arr) {
      if (bucket[i] != 0) return i;
      else bucket[i] = 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 1, 7, 7, 4, 4, 7, 5 };
    System.out.print("The result is: ");
    System.out.println(find(arr));
  }
}
