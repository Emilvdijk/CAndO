package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class TriangleManager {

  private static final ArrayList<Shape> triangleList = new ArrayList<>();

  /**
   * private constructor to prevent instantiation
   */
  private TriangleManager() {
  }

  public static ArrayList<Shape> getAll() {
    return triangleList;
  }

  static void addTriangle(Scanner myScanner) {
    System.out.println("please enter a name for your new triangle");
    String name = myScanner.nextLine();
    System.out.println("please enter triangle first side length");
    int side1 = Shape.chooseNumber(myScanner);
    System.out.println("please enter triangle second side length");
    int side2 = Shape.chooseNumber(myScanner);
    System.out.println("please enter triangle finale side length");
    int side3 = Shape.chooseNumber(myScanner);
    triangleList.add(new Triangle(name, side1, side2, side3));
  }

  static void deleteTriangle(int choice) {
    triangleList.remove(choice-1);
  }

}

