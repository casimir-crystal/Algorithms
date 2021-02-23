public class ArraysUtils {
  /**
   * Print input array for testing,
   * with the format of 5 elements per line
   */
  private static void printArray(int[] arr) {
    int newLine = 0;

    System.out.println('[');
    System.out.print("  ");
    for (int i = 0; i < arr.length; i++) {
      if (i+1 != arr.length) {
        System.out.print(arr[i] + ", ");
      } else {
        System.out.println(arr[i]);
      }

      if (newLine > 5) {
        System.out.println();
        System.out.print("  ");
        newLine = 0;
      } else {
        newLine++;
      }
    }
    System.out.println(']');
  }

  public static void reverse(int[] arr) {
    int temp;
    int len = arr.length - 1;

    for (int i=len; i >= (len / 2); i--) {
      temp = arr[i];  // temp = last;

      arr[i] = arr[len - i];  // last = first;
      arr[len - i] = temp;  // first = temp;
    }
  }

  public static int min(int[] arr) {
    int smallest = arr[0];

    for (int value: arr) {
      if (value < smallest) smallest = value;
    }

    return smallest;
  }

  public static int max(int[] arr) {
    int largest = arr[0];

    for (int value: arr) {
      if (value > largest) largest = value;
    }

    return largest;
  }

  private static int findEven(int[] arr) {
    for (int num: arr) {
      if (num % 2 == 0) {
        return num;
      }
    }
    return -1;
  }

  public static boolean hasEvenProduction(int[] arr) {
    int firstEven = findEven(arr);
    if (firstEven == -1) return false;

    for (int num: arr) {
      if (num != firstEven) return true;
    }

    return false;
  }

  public static double norm(int[] v) {
    return norm(v, 2);
  }
  public static double norm(int[] v, int p) {
    int sum = 0;

    for (int num: v) {
      sum += Math.pow(num, p);
    }

    return Math.pow(sum, 1.0 / p);
  }

  public static int[] dotProduct(int[] a, int[] b) {
    int[] c = new int[a.length];

    for (int i=0; i < a.length; i++) {
      c[i] = a[i] * b[i];
    }

    return c;
  }
}
