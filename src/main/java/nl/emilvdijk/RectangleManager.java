package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangleManager {

  private static final ArrayList<Shape> rectanglesList = new ArrayList<>();

  /**
   * private constructor to prevent instantiation
   */
  private RectangleManager() {
  }

  /**
   * returns all rectangles from the list
   * @return arraylist of shape objects containing all rectangles
   */
  public static ArrayList<Shape> getAll(){
    return rectanglesList;
  }

  /**
   * deletes a rectangle object from list of rectangle objects
   * @param choice chosen rectangle to delete
   */
  static void deleteRectangle(int choice) {
    rectanglesList.remove(choice - 1);
  }

  /**
   * makes a new rectangle object with user input and adds it to the list
   *
   */
  static void addRectangle(Scanner myScanner) {
    System.out.println("please enter a name for your new rectangle");
    String name = myScanner.nextLine();
    System.out.println("please enter rectangle width");
    int length = Shape.chooseNumber(myScanner);
    System.out.println("please enter rectangle length");
    int width = Shape.chooseNumber(myScanner);
    rectanglesList.add(new Rectangle(name, length, width));
  }
}