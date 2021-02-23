import java.util.Random;

public class RandomCipher extends SubstitutionCipher {
  private static void shuffleArray(char[] array) {
    Random r = new Random();

    for (int i=array.length - 1; i > 0; i--) {
      int index = r.nextInt(i + 1);
      // Simple swap
      char a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
  }

  private static char[] createCipher() {
    char[] cipher = new char[26];

    for (int i=0; i < 26; i++) {
      cipher[i] = (char) (i + 'A');
    }
    shuffleArray(cipher);

    return cipher;
  }

  RandomCipher() {
    super(createCipher());
  }

  public static void main(String[] args) {
    RandomCipher cipher = new RandomCipher();

    String s = "HELLO WORLD";
    System.out.println("Origin text: " + s);

    s = cipher.encode(s);
    System.out.println("Encoded text: " + s);

    s = cipher.decode(s);
    System.out.println("Decoded text: " + s);
  }
}
