public class Rational {
  public boolean isPositive;
  public Natural n;
  public Natural m;
  public Rational(boolean positive, Natural numerator, Natural denominator) {
    this.isPositive = positive;
    this.n = numerator;
    this.m = denominator;
  }

  public static Rational multiply(Rational a, Rational b) {
    return new Rational(a.isPositive == b.isPositive, Natural.multiply(a.n, b.n), Natural.multiply(a.m, b.m));
  }

  public static Rational add(Rational a, Rational b) {
    if (a.m.equals(b.m)) {
      return new Rational(a.isPositive == b.isPositive, Natural.add(a.n, b.n), a.m);
    } else {
      return new Rational(a.isPositive == b.isPositive,
        Natural.add(Natural.multiply(a.n, b.m), Natural.multiply(b.n, a.m)),
        Natural.multiply(a.m, b.m)
      );
    }
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    if (!this.isPositive) s.append('-');
    s.append(this.n.toInt());
    s.append('/');
    s.append(this.m.toInt());

    return new String(s);
  }

  public static void main(String[] args) {
    // r = 1/2
    Rational r1 = new Rational(true, Natural.fromInt(3), Natural.fromInt(5));
    Rational r2 = new Rational(true, Natural.fromInt(3), Natural.fromInt(6));
    Rational result1 = add(r1, r1);
    Rational result2 = add(r1, r2);

    System.out.println("The result of " + r1.toString() + " plus " + r1.toString() + " is " + result1.toString());
    System.out.println("The result of " + r1.toString() + " plus " + r2.toString() + " is " + result2.toString());
  }
}
