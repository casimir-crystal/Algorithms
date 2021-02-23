public class SubstitutionCipher {
  private final Character[] cipherTable;

  SubstitutionCipher(Character[] cipher) {
    cipherTable = cipher;
  }

  public String encode(String text) {
    char[] chars = text.toCharArray();

    for (int i=0; i < chars.length; i++) {
      if (chars[i] < 'A' || chars[i] > 'Z') continue;  // ignore non-upper cases
      chars[i] = cipherTable[chars[i] - 'A'];  // replace every char
    }

    return new String(chars);
  }

  public String decode(String text) {
    char[] chars = text.toCharArray();

    for (int i=0; i < chars.length; i++) {
      if (chars[i] < 'A' || chars[i] > 'Z') continue;  // ignore non-upper cases

      for (int j=0; j < cipherTable.length; j++) {
        if (chars[i] == cipherTable[j]) {
          chars[i] = (char) (j + 'A');
          break;
        }
      }
    }

    return new String(chars);
  }
}
