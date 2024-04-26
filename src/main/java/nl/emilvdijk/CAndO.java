package nl.emilvdijk;

import java.util.Scanner;


public class CAndO {

  /**
   * menu in infinite loop asks input and advances choice
   *
   */
  public static void main(String[] args) {
    System.out.println("Welcome to Rectangles and Circles and Triangles inc.");
    while (true) {
      Scanner myScanner = new Scanner(System.in);
      System.out.println("""
        
          1 Rectangles menu
          2 Circles menu
          3 Triangle menu
          0 quit
          """);

      while (!myScanner.hasNextInt()) {
        System.out.println("Please enter a number to choose.");
        myScanner.next();
      }

      switch (myScanner.nextLine()) {
        case "1":
          RectangleMenu.menu(myScanner);
          break;
        case "2":
          CircleMenu.menu(myScanner);
          break;
        case "3":
          TriangleMenu.menu(myScanner);
          break;
        case "0":
          return;
        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }
}
