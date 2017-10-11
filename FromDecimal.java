import java.util.*;
public class FromDecimal {
  public static void main(String[] args) throws java.io.IOException {
    java.io.BufferedReader keyboard
         = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));

    String s = keyboard.readLine();

    final int TARGET_BASE = Integer.parseInt(args[0]);

    int num = Integer.parseInt(s);

    System.out.println(num);
    System.out.println(TARGET_BASE);

    int n = 0;
    while (num >= Math.pow(TARGET_BASE, n)) {
      n++;
    }

    int[] targetNum = new int[n];

    convertBase(TARGET_BASE, num, targetNum);
    System.out.println(Arrays.toString(targetNum));

    String finalNum = "";

    for (int i = 0; i < targetNum.length; i++) {
      finalNum = finalNum + "[" + targetNum[i] + "]";
    }

    System.out.println(finalNum);

  }

  //base is target base
  public static void convertBase(int targetBase, int num, int[] a) {
    //while loop to find n
    //for loop to find coefficients and put them into an arraylist
    int n2 = a.length - 1;
    int number = num;
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
