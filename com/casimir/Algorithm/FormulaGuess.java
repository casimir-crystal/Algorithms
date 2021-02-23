import java.util.Scanner;

public class FormulaGuess {
  private enum FormulaType { leftop, rightop, opnotfound }
  private final static char[] operators = { '+', '-', '*', '/' };

  interface MathOperation {
    int operation(int a, int b);
  }

  static MathOperation addition = (int a, int b) -> a + b;
  static MathOperation subtraction = (int a, int b) -> a - b;
  static MathOperation multiplication = (int a, int b) -> a * b;
  static MathOperation division = (int a, int b) -> a / b;

  static MathOperation[] calculations = { addition, subtraction, multiplication, division };

  private static FormulaType guessFormula(int a, int b, int c, MathOperation calc) {
    if (calc.operation(a, b) == c) {
      return FormulaType.leftop;  // Result found as a . b == c
    } else if (a == calc.operation(b, c)) {
      return FormulaType.rightop;  // Result found as a == b . c
    }

    return FormulaType.opnotfound;  // Result not found
  }

  private static String formula(int num1, int num2, int num3) {
    for (int index=0; index < calculations.length; index++) {
      FormulaType type = guessFormula(num1, num2, num3, calculations[index]);

      switch (type) {
        case leftop:   // Result is found
          return "a " + operators[index] + " b = c";
        case rightop:
          return "a = b " + operators[index] + " c";
      }
    }

    return "No result";
  }

  private static int getInteger(String prompt) {
    Scanner input = new Scanner(System.in);

    System.out.print(prompt);

    while(!input.hasNextInt()) {
      input.nextLine();
      System.out.print("Invalid integer; " + prompt);
    }

    return input.nextInt();
  }

  public static void main(String[] args) {
    int a = getInteger("Please enter the first integer [a]: ");
    int b = getInteger("Please enter the second integer [b]: ");
    int c = getInteger("Please enter the third integer [c]: ");

    System.out.println("Guessing formula of your numbers is: ");
    System.out.println(formula(a, b, c));
  }
}
