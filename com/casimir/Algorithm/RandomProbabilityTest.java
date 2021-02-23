import java.util.Random;

public class RandomProbabilityTest {
  private static final int n = 3;
  private static final int m = 10;

  private static long getRandomProduct(Random r) {
    long result = 1;

    for (int i=0; i < m; i++) {
      result *= r.nextInt(n);
    }

    return result;
  }

  public static void main(String[] args) {
    int isZero = 0;
    int notZero = 0;

    Random r = new Random();
    for (int i=0; i < 1000000; i++) {
      if (getRandomProduct(r) == 0) {
        isZero++;
      } else {
        notZero++;
      }
    }

    System.out.print("Possible the result is zero in 1,000,000 times is: ");
    System.out.println(isZero);

    System.out.print("Possible the result isn't zero in 1,000,000 times is: ");
    System.out.println(notZero);

    System.out.println();

    System.out.println("The probability: ");
    System.out.println(1.0 / 1000000 * isZero);
  }
}
