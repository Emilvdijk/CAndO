package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class TriangleMenu {

  /**
   * private constructor to prevent instantiation
   */
  private TriangleMenu() {
  }

  /**
   * looping menu that asks user input and advances chosen option
   *
   * @param myScanner reuse scanner
   */
  static void menu(Scanner myScanner) {
    System.out.println("triangle Manager");
    while (true) {
      System.out.println("""
          1 list triangles
          2 Create new triangle
          3 Remove triangle
          4 Calculate circumference of a triangle
          5 Calculate circumference of a saved triangle
          6 Calculate Surface area of a triangle
          7 Calculate Surface area of a saved triangle
          8 Calculate distance between fence poles based on amount of poles of a saved triangle
          9 Calculate amount of fence poles based on distance between poles of a saved triangle
          0 back
          """);

      while (!myScanner.hasNextInt()) {
        System.out.println("Please enter a number to choose.");
        myScanner.next();
      }

      switch (myScanner.nextLine()) {
        case "1":
          triangleListPrinter();
          break;

        case "2":
          TriangleManager.addTriangle(myScanner);
          break;

        case "3":
          deleteTriangle(myScanner);
          break;

        case "4":
          circumferenceCalc(myScanner);
          break;

        case "5":
          circumferenceOfTriangleCalc(myScanner);
          break;

        case "6":
          surfaceAreaCalc(myScanner);
          break;

        case "7":
          surfaceAreaOfTriangleCalc(myScanner);
          break;

        case "8":
          calcPoleDistanceOfTriangle(myScanner);
          break;

        case "9":
          calcPoleAmountOfTriangle(myScanner);
          break;

        case "0":
          return;

        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }

  /**
   * prints out all triangle details from the list
   */
  private static void triangleListPrinter() {
    ArrayList<Shape> triangles = TriangleManager.getAll();

    if (triangles.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Shape triangle : triangles) {
      System.out.println(triangle.toFormattedString());
    }
  }

  /**
   * user chooses a triangle form list and deletes it
   * @param myScanner reuse scanner
   */
  private static void deleteTriangle(Scanner myScanner) {
    ArrayList<Shape> triangles = TriangleManager.getAll();
    if (triangles.isEmpty()) {
      System.out.println("no items to delete");
      return;
    }
    System.out.println("Which triangle would you like to delete:");
    int choice = CAndO.chooseFromList(triangles, myScanner);
    TriangleManager.deleteTriangle(choice);
  }

  /**
   * user inputs 3 sides to a triangle and circumference is printed
   *
   * @param myScanner reuse scanner
   */
  private static void circumferenceCalc(Scanner myScanner) {
    System.out.println("please enter triangle first side length");
    int side1 = CAndO.chooseNumber(myScanner);
    System.out.println("please enter triangle second side length");
    int side2 = CAndO.chooseNumber(myScanner);
    System.out.println("please enter triangle finale side length");
    int side3 = CAndO.chooseNumber(myScanner);
    System.out.printf("circumference is: %s %n", Triangle.calcCircumference(side1, side2, side3));
  }

  /**
   * user picks triangle and circumference of triangle is printed
   * @param myScanner reuse scanner
   */
  private static void circumferenceOfTriangleCalc(Scanner myScanner) {
    ArrayList<Shape> triangles = TriangleManager.getAll();
    if (triangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select triangle to calculate circumference of");
    int choice = CAndO.chooseFromList(triangles, myScanner);
    System.out.printf("circumference of %s is: %s %n", triangles.get(choice - 1).getName(),
        triangles.get(choice - 1).calcCircumference());
  }

  /**
   * user inputs sides to a triangle and surface area is printed
   * @param myScanner reuse scanner
   */
  private static void surfaceAreaCalc(Scanner myScanner) {
    System.out.println("please enter triangle first side length");
    int side1 = CAndO.chooseNumber(myScanner);
    System.out.println("please enter triangle second side length");
    int side2 = CAndO.chooseNumber(myScanner);
    System.out.println("please enter triangle finale side length");
    int side3 = CAndO.chooseNumber(myScanner);
    System.out.printf("surface area is: %s %n", Triangle.calcSurfaceArea(side1,side2,side3));

  }

  /**
   * user picks triangle and surface area of triangle is printed
   * @param myScanner reuse scanner
   */
  private static void surfaceAreaOfTriangleCalc(Scanner myScanner) {
    ArrayList<Shape> triangles = TriangleManager.getAll();
    if (triangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select triangle to calculate surface area of");
    int choice = CAndO.chooseFromList(triangles, myScanner);
    System.out.printf("surface area of %s is: %s %n", triangles.get(choice - 1).getName(),
        triangles.get(choice - 1).calcSurfaceArea());
  }


  /**
   * user picks triangle object and amount of poles and the distance is between poles is printed
   * @param myScanner reuse scanner
   */
  private static void calcPoleDistanceOfTriangle(Scanner myScanner) {
    ArrayList<Shape> triangles = TriangleManager.getAll();
    if (triangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select triangle to calculate distance between poles");
    int choice = CAndO.chooseFromList(triangles, myScanner);
    System.out.println("how many poles are in the fence");
    int amountOfPoles = CAndO.chooseNumber(myScanner);
    System.out.printf("distance between poles of %s is: %s %n",
        triangles.get(choice - 1).getName(),
        triangles.get(choice - 1).calcPoleDistance(amountOfPoles));
  }

  /**
   * user picks triangle and distance between poles and amount of poles needed is printed
   * @param myScanner reuse scanner
   */
  private static void calcPoleAmountOfTriangle(Scanner myScanner) {
    ArrayList<Shape> triangles = TriangleManager.getAll();
    if (triangles.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate amount of poles");

    int choice = CAndO.chooseFromList(triangles, myScanner);
    System.out.println("enter the distance between poles (can be decimal number)");
    double poleDistance = CAndO.chooseDouble(myScanner);
    System.out.printf("amount of poles in the fence around %s is: %s %n",
        triangles.get(choice - 1).getName(),
        triangles.get(choice - 1).calcPoleAmount(poleDistance));
  }

}
