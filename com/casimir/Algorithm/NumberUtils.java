public class NumberUtils {
  public static boolean isMultiple(long n, long m) {
    return n % m == 0;
  }

  /**
  * Test if an integer is even number, without using modulus operators
  */
  public static boolean isEven(int i) {
    return (i & 1) != 1;
  }

  /**
  * Calculate sum of [1...n], return the sum
  */
  public static int sumTo(int n) {
    return (n * n + n) / 2;
  }

  /**
  * Calculate sum of [1...n] with only odd numbers, return the sum
  */
  public static int sumOddTo(int n) {
    int sum = 0;

    for (int i = 1; i <= n; i++) {
      if (!isEven(i)) sum += i;
    }

    return sum;
  }

  /**
  * Calculate sum of [1...n] with numbers squared, return the sum
  */
  public static int sumSquaredTo(int n) {
    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += i * i;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println("TEST: isMultiple(n, m)");
    long testNum = 5;
    long numbers[] = { 40, 100, 98, 24, 155 };

    for (long num: numbers) {
      System.out.println(num + " is multiple of " + testNum +": " + isMultiple(num, testNum));
    }
    System.out.println();

    System.out.println("TEST: isEven(i)");
    for (int i=1; i < 11; i++) {
      System.out.println(i + " is even: " + isEven(i));
    }
    System.out.println();

    System.out.println("TEST: sumTo(n)");
    System.out.println("Sum from 1 to 4 equals: " + sumTo(4));
    System.out.println("Sum from 1 to 100 equals: " + sumTo(100));
    System.out.println();

    System.out.println("TEST: sumTo(n)");
    System.out.println("Sum from 1 to 4 equals: " + sumTo(4));
    System.out.println("Sum from 1 to 100 equals: " + sumTo(100));
    System.out.println();

    System.out.println("TEST: sumOddTo(n)");
    System.out.println("Sum from 1 to 4 equals: " + sumOddTo(4));
    System.out.println("Sum from 1 to 100 equals: " + sumOddTo(100));
    System.out.println();

    System.out.println("TEST: sumSquaredTo(n)");
    System.out.println("Sum from 1 to 5 equals: " + sumSquaredTo(5));
    System.out.println("Sum from 1 to 12 equals: " + sumSquaredTo(12));
    System.out.println();
  }
}
