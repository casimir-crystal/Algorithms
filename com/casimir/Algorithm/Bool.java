public abstract class Bool {
  private static boolean isTrue(Bool bool) {
    return bool instanceof True;
  }

  private static boolean isFalse(Bool bool) {
    return bool instanceof False;
  }

  public static Bool not(Bool bool) {
     return (isFalse(bool)) ? new True() : new False();
  }

  public static Bool or(Bool a, Bool b) {
    return isTrue(a) ? new True() : b;
  }

  public static Bool and(Bool a, Bool b) {
    return isTrue(a) ? b : new False();
  }

  public static Bool implication(Bool a, Bool b) {
    return isTrue(and(a, not(b))) ? new False() : new True();
  }

  public static void main(String[] args) {
    Bool[] bools = {new True(), new False()};

    for (Bool a: bools) {
      for (Bool b: bools) {
        for (Bool c: bools) {
        }
      }
    }
  }
}

class True extends Bool {
  public String toString() {
    return "True";
  }
}

class False extends Bool{
  public String toString() {
    return "False";
  }
}
