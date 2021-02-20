import java.util.Random;

public class RandomShuffle {
  private static void swap(int[] arr, int from, int to) {
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

  public static void shuffle(int[] arr) {
    shuffle(arr, arr.length-1);
  }

  public static void shuffle(int[] arr, int index) {
    Random r = new Random();

    // array swap-shuffle
    swap(arr, r.nextInt(index+1), index);
    if (index > 0) shuffle(arr, index - 1);
  }
}
