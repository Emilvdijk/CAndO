package nl.emilvdijk;

import java.util.Scanner;

/** Hello world! */
public class CAndO {

  public static void main(String[] args) {}

  private void ShowMenu() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println(
        """
Welcome to Rectangles and Circles co
1 show
2 Rectangles
3 Circles
0 quit
""");
    while (!myScanner.hasNextInt()) {
      System.out.println("please enter a number to choose an option.");
      myScanner.next();
    }
    char choice = myScanner.nextLine().charAt(0);
    switch (choice) {
      case '1':
        break;
      case '2':
        break;
      case '3':
        break;
      case '0':
        break;
    }
  }
}
