public class Permutation {
  private static int times = 0;

  private static void printChars(char[] characters) {
    StringBuilder str = new StringBuilder();
    for (char c: characters) {
      str.append(c);
    }
    times++;
    System.out.println(times + ": " + str);
  }

  private static void swap(char[] arr, int from, int to) {
    char temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

  public static void getPermutation(char[] chars) {
    getPermutation(chars, 0);
  }

  private static void getPermutation(char[] chars, int levelNum) {
    if (levelNum == chars.length) {
      printChars(chars);
    }

    getPermutation(chars, levelNum, levelNum);
  }

  private static void getPermutation(char[] chars, int level, int index) {
    if (index < chars.length) {
      swap(chars, level, index);
      getPermutation(chars, level+1);
      swap(chars, level, index);

      getPermutation(chars, level, index + 1);
    }
  }

  public static void main(String[] args) {
    char[] chars = {'c', 'a', 't', 'd', 'o', 'g'};
    getPermutation(chars);
  }
}
