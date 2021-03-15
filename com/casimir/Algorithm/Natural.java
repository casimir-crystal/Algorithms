public abstract class Natural {
  public Natural previous() {
    return ((Succ) this).num;
  }

  public static Natural multiply(Natural number, Natural times) {
    if (times.isZero()) {
      return new Zero();
    } else {
      return add(number, multiply(number, times.previous()));
    }
  }

  public static Natural add(Natural a, Natural b) {
    if (b.isZero()) {
      return a;
    } else {
      return new Succ(add(a, b.previous()));
    }
  }

  public static Natural fromInt(int n) {
    Natural num = new Zero();

    while (n > 0) {
      num = new Succ(num);
      n--;
    }

    return num;
  }

  public static int toInt(Natural n) {
    int val = 0;

    while (!n.isZero()) {
      n = n.previous();
      val++;
    }

    return val;
  }

  public boolean isZero() {
    return this instanceof Zero;
  }

  static class Zero extends Natural {}

  static class Succ extends Natural {
    public final Natural num;
    public Succ(Natural n) {
      this.num = n;
    }
  }

  public static void main(String[] args) {
    // for example, 3 * 4 outs 12
    System.out.println(toInt(multiply(fromInt(3), fromInt(4))));
  }
}

