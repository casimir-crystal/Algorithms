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

  public boolean equals(Natural nat) {
    Natural a = this;
    Natural b = nat;

    while (!a.isZero() && !b.isZero()) {
      a = a.previous();
      b = b.previous();
    }

    return a.isZero() && b.isZero();
  }

  public int toInt(int n, Natural nat) {
    if (nat.isZero()) {
      return n;
    } else {
      return toInt(n+1, nat.previous());
    }
  }

  public int toInt() {
    return toInt(0, this);
  }

  public boolean isZero() {
    return this instanceof Zero;
  }

  static class Zero extends Natural {
  }

  static class Succ extends Natural {
    public final Natural num;
    public Succ(Natural n) {
      this.num = n;
    }
  }

  public static void main(String[] args) {
    // for example, 3 * 4 outs 12
    System.out.println(multiply(fromInt(3), fromInt(4)).toInt());
  }
}

