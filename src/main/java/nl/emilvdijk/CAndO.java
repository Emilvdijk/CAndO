package nl.emilvdijk;

import java.util.ArrayList;
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

  /**
   * asks user to select a shape from list
   * @param shape list of shapes
   * @param myScanner reuse scanner
   * @return returns choice
   */
  static int chooseFromList(ArrayList<Shape> shape, Scanner myScanner) {
    for (int y = 0; y < shape.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, shape.get(y).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= shape.size()));
    return choice;
  }

  /**
   * takes user input and returns number
   * @param myScanner reuse scanner
   * @return a number chosen by user
   */
  static int chooseNumber(Scanner myScanner){
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int chosenNumber = myScanner.nextInt();
    myScanner.nextLine();
    return chosenNumber;
  }

  /**
   * takes user input and returns number
   * @param myScanner reuse scanner
   * @return number chosen by user
   */
  static double chooseDouble(Scanner myScanner){
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    double chosenNumber = myScanner.nextDouble();
    myScanner.nextLine();
    return chosenNumber;
  }
}
