public abstract class Natural {
  public Natural previous() {
    return ((Succ) this).num;
  }

  private static Natural gcd(Natural maxNum, Natural minNum, Natural result) {
    if (minNum.eq(max(minNum, result))) {
      return result;
    } else {
      return gcd(maxNum, minNum, subtract(result, minNum));
    }
  }

  public static Natural gcd(Natural a, Natural b) {
    // if a == b then return 1
    if (a.eq(b)) return new Succ(new Zero());

    Natural maxNum = max(a, b);
    Natural minNum = (maxNum.eq(a)) ? b : a;

    return gcd(maxNum, minNum, subtract(maxNum, minNum));
  }

  private static Natural divide(Natural divisor, Natural dividend, Natural result) {
    if (divisor.eq(multiply(result, dividend))) {
      return result;
    } else {
      return divide(divisor, dividend, new Succ(result));
    }
  }

  public static Natural divide(Natural divisor, Natural dividend) {
    return divide(divisor, dividend, new Succ(new Zero()));
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

  public static Natural subtract(Natural a, Natural b) {
    if (b.isZero()) {
      return a;
    } else {
      return subtract(a.previous(), b.previous());
    }
  }

  private static Natural fromInt(int n, Natural nat) {
    if (n == 0) {
      return nat;
    } else {
      return fromInt(n-1, new Succ(nat));
    }
  }

  public static Natural fromInt(int n) {
    return fromInt(n, new Zero());
  }

  private int toInt(int n, Natural nat) {
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

  public boolean greaterThan(Natural nat) {
    // return not(a - b <= 0);
    return !(subtract(this, nat).eq(new Zero()));
  }

  public boolean eq(Natural nat) {
    Natural a = this;
    Natural b = nat;

    while (!a.isZero() && !b.isZero()) {
      a = a.previous();
      b = b.previous();
    }

    return a.isZero() && b.isZero();
  }

  public static Natural max(Natural a, Natural b) {
    Natural a_ = a;
    Natural b_ = b;

    while (!a_.isZero() && !b_.isZero()) {
      a_ = a_.previous();
      b_ = b_.previous();
    }

    return a_.isZero() ? b : a;
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
    System.out.println(divide(fromInt(100), fromInt(5)).toInt());
  }
}
