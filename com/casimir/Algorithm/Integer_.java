public abstract class Integer_ {
  public boolean isPositive = true;

  public static Integer_ multiply(Integer_ number, Integer_ times) {
    if (times instanceof IntSucc) {
      // `((IntSucc)times).num` is equal to `times--`
      return add(number, multiply(number, ((IntSucc)times).num));
    } else {
      return new IntZero();
    }
  }

  public static Integer_ add(Integer_ a, Integer_ b) {
    if (b instanceof IntSucc) {
      if (a.isPositive != b.isPositive) {
        if (a instanceof IntSucc) {
          return add(((IntSucc)a).num, ((IntSucc)b).num);
        } else {
          a.isPositive = !a.isPositive;
        }
      }
      return new IntSucc(add(a, ((IntSucc)b).num));
    } else {
      return a;
    }
  }

  public static Integer_ fromInt(int n) {
    Integer_ num = new IntZero();
    if (n < 0) {
      num.isPositive = false;
      n = -n; // abs(n)
    }

    while (n > 0) {
      num = new IntSucc(num);
      n--;
    }

    return num;
  }

  public static int toInt(Integer_ n) {
    int val = 0;

    while (n instanceof IntSucc) {
      n = ((IntSucc)n).num;
      val++;
    }

    assert(n instanceof IntZero);

    if (!n.isPositive) {
      val = -val;
    }

    return val;
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

  class IntZero extends Integer_ {

  }

  class IntSucc extends Integer_ {
    public final Integer_ num;

    public IntSucc(Integer_ n) {
      this.num = n;
      this.isPositive = n.isPositive;
    }
  }
