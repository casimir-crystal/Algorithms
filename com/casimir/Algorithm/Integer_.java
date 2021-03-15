public class Integer_ {
  public boolean isPositive = true;
  public Natural n;

  public Integer_(Natural nat) {
    this.n = nat;
  }
  public Integer_() {
    this.n = new Zero();
  }

  //TODO: complete this method;
  public static void multiply(Integer_ number, Integer_ times) {
  }

  public static Integer_ add(Integer_ a, Integer_ b) {
    if (a.isPositive != b.isPositive) {
      // both sides mine one, until which equals to Zero
      while (a.n instanceof Succ && b.n instanceof Succ) {
        a.n = ((Succ) a.n).num;
        b.n = ((Succ) b.n).num;
      }

      return a.n instanceof Succ ? a : b;
    } else {
      Integer_ result = new Integer_(Natural.add(a.n, b.n));
      result.isPositive = a.isPositive;
      return result;
    }
  }

  public static Integer_ fromInt(int n) {
    Integer_ int_ = new Integer_();
    if (n < 0) {
      int_.isPositive = false;
      n = -n;
    }

    int_.n = Natural.fromInt(n);

    return int_;
  }

  public static int toInt(Integer_ int_) {
    int num = Natural.toInt(int_.n);

    if (!int_.isPositive) {
      num = -num;
    }

    return num;
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
  }
}
