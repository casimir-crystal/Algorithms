import java.util.Random;

public class RandomShuffle {
  private static <T> void swap(T[] arr, int from, int to) {
    T temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

  public static <T> void shuffle(T[] arr) {
    shuffle(arr, arr.length-1);
  }

  public static <T> void shuffle(T[] arr, int index) {
    Random r = new Random();

    // array swap-shuffle
    swap(arr, r.nextInt(index+1), index);
    if (index > 0) shuffle(arr, index - 1);
  }
}
