/**Base conversion program that takes a starting base via args[0] and a number in
that starting base via standard input, and converts it into base ten. */
public class ToDecimal {

   /**Gets the data, calls the baseConverter, outputs the base ten number. */
   public static void main(String[] args) throws java.io.IOException {

      //takes input from the standard input system
      java.io.BufferedReader keyboard
         = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));

      String s = keyboard.readLine();

      if (args.length == 0) {
         throw new IllegalArgumentException("no valid starting base given");
      }

      for (int i = 0; i < args[0].length(); i++) {
        if (!(Character.isDigit(args[0].charAt(i)))) {
          throw new IllegalArgumentException("no valid starting base given");
        }
      }

      if (s.indexOf('[') == -1) {
         throw new IllegalArgumentException("invalid standard input");
      }

      //converts args[0] to an int which is the starting base
      final int STARTING_BASE = Integer.parseInt(args[0]);

      //creates a string of the original number from standard input
      //by removing the outside brackets from it
      String noBrackets = s.substring(1, s.length() - 1);

      //takes out the brackets, replacing "][" with " "
      for (int i = 0; i < noBrackets.length() - 1; i++) {
         if (noBrackets.charAt(i) == ']' && noBrackets.charAt(i + 1) == '[') {
            noBrackets = noBrackets.substring(0, i) + ' '
               + noBrackets.substring(i + 2);
         }
      }

      for (int i = 0; i < noBrackets.length(); i++) {
         if (!(Character.isDigit(noBrackets.charAt(i))) &&
            (!(Character.isSpaceChar(noBrackets.charAt(i))))) {
            throw new IllegalArgumentException("invalid standard input");
         }
      }

      String[] strArray = noBrackets.split(" ");

      for (int i = 0; i < strArray.length; i++) {
         if (STARTING_BASE <= Integer.parseInt(strArray[i])) {
            throw new IllegalArgumentException("digit not allowed to be greater than base");
         }
      }

      int[] a = new int[strArray.length];

      for (int i = 0; i < a.length; i++) {
         a[i] = Integer.parseInt(strArray[i]);
      }

      //converts the number from the starting base to its decimal form and
      //prints out the converted answer, a number in decimal form (base ten)
      System.out.println(convertToDecimal(STARTING_BASE, a));
   }

   //method that takes in a starting base and an integer array that represents
   //the original number in the starting base, converts that number into base ten,
   //and returns the base ten number
   public static int convertToDecimal(int startingBase, int[] array) {
      int convertedNumber = array[0];
      for (int i = 0; i < array.length - 1; i++) {
         convertedNumber = (convertedNumber * startingBase) + array[i + 1];
      }
      return convertedNumber;
   }
   
}
