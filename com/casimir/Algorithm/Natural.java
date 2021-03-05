public abstract class Natural {
  public static Natural multiply(Natural number, Natural times) {
    if (times instanceof Succ) {
      // `((Succ)times).num` is equal to `times--`
      return add(number, multiply(number, ((Succ)times).num));
    } else {
      return new Zero();
    }
  }

  public static Natural add(Natural a, Natural b) {
    if (b instanceof Succ) {
      return new Succ(add(a, ((Succ)b).num));
    } else {
      return a;
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

    while (n instanceof Succ) {
      n = ((Succ)n).num;
      val++;
    }

    assert(n instanceof Zero);
    return val;
  }

  public static void main(String[] args) {
    // for example, 3 * 4 outs 12
    System.out.println(toInt(multiply(fromInt(3), fromInt(4))));
  }
}

class Zero extends Natural {}

class Succ extends Natural {
  public final Natural num;

  public Succ(Natural n) {
    this.num = n;
  }
}
