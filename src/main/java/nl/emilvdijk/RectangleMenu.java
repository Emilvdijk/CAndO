package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangleMenu {

  /**
   * private constructor to prevent instantiation
   */
  private RectangleMenu() {
  }

  /**
   * looping menu that asks user input and advances chosen option
   */
  static void menu(Scanner myScanner) {
    System.out.println("Rectangles Manager");
    while (true) {
      System.out.println("""
          1 list rectangles
          2 Create new rectangle
          3 Remove rectangle
          4 Calculate circumference of a rectangle
          5 Calculate circumference of a saved rectangle
          6 Calculate Surface area of a rectangle
          7 Calculate Surface area of a saved rectangle
          8 Calculate distance between fence poles based on amount of poles of a saved rectangle
          9 Calculate amount of fence poles based on distance between poles of a saved rectangle
          0 back
          """);

      while (!myScanner.hasNextInt()) {
        System.out.println("Please enter a number to choose.");
        myScanner.next();
      }

      switch (myScanner.nextLine()) {
        case "1":
          rectangleListPrinter();
          break;

        case "2":
          RectangleManager.addRectangle(myScanner);
          break;

        case "3":
          deleteRectangle(myScanner);
          break;

        case "4":
          circumferenceCalc(myScanner);
          break;

        case "5":
          circumferenceOfRectangleCalc(myScanner);
          break;

        case "6":
          surfaceAreaCalc(myScanner);
          break;

        case "7":
          surfaceAreaOfRectangleCalc(myScanner);
          break;

        case "8":
          calcPoleDistanceOfRectangle(myScanner);
          break;

        case "9":
          calcPoleAmountOfRectangle(myScanner);
          break;

        case "0":
          return;

        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }

  /**
   * prints out all rectangle object details
   */
  private static void rectangleListPrinter() {
    ArrayList<Shape> rectangles = RectangleManager.getAll();

    if (rectangles.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Shape rectangle : rectangles) {
      System.out.println(rectangle.toFormattedString());
    }
  }


  /**
   * selects a rectangle from the list and deletes it
   *
   * @param myScanner reuse scanner
   */
  private static void deleteRectangle(Scanner myScanner) {
    ArrayList<Shape> rectangles = RectangleManager.getAll();
    if (rectangles.isEmpty()) {
      System.out.println("no items to delete");
      return;
    }
    System.out.println("Which rectangle would you like to delete:");
    int choice = CAndO.chooseFromList(rectangles, myScanner);
    RectangleManager.deleteRectangle(choice);
  }

  /**
   * asks user for a length and width and prints out its circumference
   */
  private static void circumferenceCalc(Scanner myScanner) {
    System.out.println("please enter length");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int length = myScanner.nextInt();
    System.out.println("please enter width");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    int width = myScanner.nextInt();
    System.out.printf("circumference is: %s %n", Rectangle.calcCircumference(length, width));
  }

  /**
   * asks user to choose a rectangle object and prints out its circumference
   */
  private static void circumferenceOfRectangleCalc(Scanner myScanner) {
    ArrayList<Shape> rectangles = RectangleManager.getAll();
    if (rectangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate circumference of");
    int choice = CAndO.chooseFromList(rectangles, myScanner);
    System.out.printf("circumference of %s is: %s %n", rectangles.get(choice - 1).getName(),
        rectangles.get(choice - 1).calcCircumference());
  }

  /**
   * asks user for a length and width to calculate surface area of and prints out result
   */
  private static void surfaceAreaCalc(Scanner myScanner) {
    System.out.println("please enter length");
    int length = CAndO.chooseNumber(myScanner);
    System.out.println("please enter width");
    int width = CAndO.chooseNumber(myScanner);
    System.out.printf("surface area is: %s %n", Rectangle.calcSurfaceArea(length, width));
  }

  /**
   * asks user to select a rectangle object and prints out its surface area
   */
  private static void surfaceAreaOfRectangleCalc(Scanner myScanner) {
    ArrayList<Shape> rectangles = RectangleManager.getAll();
    if (rectangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate surface area of");
    int choice = CAndO.chooseFromList(rectangles, myScanner);
    System.out.printf("surface area of %s is: %s %n", rectangles.get(choice - 1).getName(),
        rectangles.get(choice - 1).calcSurfaceArea());
  }

  /**
   * asks user to select a rectangle object and an amount of poles and prints out distance between
   * poles
   */
  private static void calcPoleDistanceOfRectangle(Scanner myScanner) {
    ArrayList<Shape> rectangles = RectangleManager.getAll();
    if (rectangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate distance between poles");
    int choice = CAndO.chooseFromList(rectangles, myScanner);

    System.out.println("how many poles are in the fence");
    int amountOfPoles = CAndO.chooseNumber(myScanner);
    System.out.printf("distance between poles of %s is: %s %n",
        rectangles.get(choice - 1).getName(),
        rectangles.get(choice - 1).calcPoleDistance(amountOfPoles));
  }

  /**
   * asks user to select a rectangle object and distance between poles and prints out the amount of
   * poles
   */
  private static void calcPoleAmountOfRectangle(Scanner myScanner) {
    ArrayList<Shape> rectangles = RectangleManager.getAll();
    if (rectangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate amount of poles");

    int choiceRectangle = CAndO.chooseFromList(rectangles, myScanner);

    System.out.println("enter the distance between poles (can be decimal number)");
    double poleDistance = CAndO.chooseDouble(myScanner);
    System.out.printf("amount of poles in the fence around %s is: %s %n",
        rectangles.get(choiceRectangle - 1).getName(),
        rectangles.get(choiceRectangle - 1).calcPoleAmount(poleDistance));
  }

}
