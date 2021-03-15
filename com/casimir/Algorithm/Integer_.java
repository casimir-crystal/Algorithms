public class Integer_ {
  public boolean isPositive;
  public Natural n;

  public Integer_(boolean positive, Natural nat) {
    this.n = nat;
    this.isPositive = positive;
  }

  public static Integer_ multiply(Integer_ a, Integer_ b) {
    return new Integer_(a.isPositive == b.isPositive, Natural.multiply(a.n, b.n));
  }

  public static Integer_ add(Integer_ a, Integer_ b) {
    if (a.isPositive != b.isPositive) {
      Natural aNum = a.n;
      Natural bNum = b.n;
      // both sides minus one, until which equals to Zero
      while (!aNum.isZero() && !bNum.isZero()) {
        aNum = aNum.previous();
        bNum = bNum.previous();
      }

      if (!aNum.isZero()) {
        return new Integer_(a.isPositive, aNum);
      } else {
        return new Integer_(b.isPositive, bNum);
      }
    } else {
      return new Integer_(a.isPositive, Natural.add(a.n, b.n));
    }
  }

  public static Integer_ fromInt(int n) {
    return new Integer_((n >= 0), Natural.fromInt(Math.abs(n)));
  }

  public static int toInt(Integer_ int_) {
    int num = Natural.toInt(int_.n);

    if (!int_.isPositive) {
      return -num;
    } else {
      return num;
    }
  }

  public static void main(String[] args) {
    System.out.print("3 + (-4) = ");
    System.out.println(toInt(add(fromInt(3), fromInt(-4))));
    System.out.print("(-2) + (-10) = ");
    System.out.println(toInt(add(fromInt(-2), fromInt(-10))));
    System.out.print("(-2) + 10 = ");
    System.out.println(toInt(add(fromInt(-2), fromInt(10))));
    System.out.print("5 + 10 = ");
    System.out.println(toInt(add(fromInt(5), fromInt(10))));

    System.out.print("3 * (-4) = ");
    System.out.println(toInt(multiply(fromInt(3), fromInt(-4))));
    System.out.print("(-2) * (-10) = ");
    System.out.println(toInt(multiply(fromInt(-2), fromInt(-10))));
    System.out.print("(-2) * 10 = ");
    System.out.println(toInt(multiply(fromInt(-2), fromInt(10))));
    System.out.print("5 * 10 = ");
    System.out.println(toInt(multiply(fromInt(5), fromInt(10))));
  }
}
