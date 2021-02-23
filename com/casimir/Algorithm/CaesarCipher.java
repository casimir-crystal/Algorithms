public class CaesarCipher extends SubstitutionCipher {
  private static Character[] createCipher() {
    Character[] cipher = new Character[26];
    for (int i=0; i < 26; i++) {
      cipher[i] = (char) ((i + 3) % 26 + 'A');
    }

    return cipher;
  }

  CaesarCipher() {
    super(createCipher());
  }

  public static void main(String[] args) {
    CaesarCipher cipher = new CaesarCipher();

    String s = "HELLO WORLD";
    System.out.println("Origin text: " + s);

    s = cipher.encode(s);
    System.out.println("Encoded text: " + s);

    s = cipher.decode(s);
    System.out.println("Decoded text: " + s);
  }
}
