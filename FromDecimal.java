/** Base conversion program that takes a number in base ten via standard
input, and returns a number in the base specified by args[0] */
public class FromDecimal {

  /** Gets the data, calls convertBase, prints the number in the correct format */
  public static void main(String[] args) throws java.io.IOException {

    //takes input from the standard input system
    java.io.BufferedReader keyboard
         = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));

    String s = keyboard.readLine();

    if (args.length == 0) {
       throw new IllegalArgumentException("no valid target base given");
    }

    for (int i = 0; i < args[0].length(); i++) {
      if (!(Character.isDigit(args[0].charAt(i)))) {
        throw new IllegalArgumentException("no valid target base given");
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (!(Character.isDigit(s.charAt(i)))) {
        throw new IllegalArgumentException("invalid standard input");
      }
    }

    final int TARGET_BASE = Integer.parseInt(args[0]);

    if (TARGET_BASE < 2) {
      throw new IllegalArgumentException("target base must be greater than or equal to 2");
    }

    int num = Integer.parseInt(s);

    // finds the number of digits the number in the target base will be
    int n = 0;
    while (num >= Math.pow(TARGET_BASE, n)) {
      n++;
    }

    int[] targetNum = new int[n];

    convertBase(TARGET_BASE, num, targetNum);

    // creates a string of digits to output in the correct format
    // with each digit inside brackets (ex: [1][2][3])
    String finalNum = "";

    for (int i = 0; i < targetNum.length; i++) {
      finalNum = finalNum + "[" + targetNum[i] + "]";
    }

    System.out.println(finalNum);

  }

  // method that takes in a target base, a number in base ten, and an
  // array and converts the number into the target base and then
  // fills the array with the digits of the new converted number
  public static void convertBase(int targetBase, int num, int[] a) {
    int n2 = a.length - 1;
    int number = num;
    //for loop to find coefficients and put them into an array
    for (int i = n2; i >= 0; i--) {
      int coef = 0;
      while (number >= coef * Math.pow(targetBase, n2)) {
        coef++;
      }
      coef--;
      a[a.length - 1 - n2] = coef;
      number = number - coef * (int)Math.pow(targetBase, n2);
      n2--;
    }
  }

}
