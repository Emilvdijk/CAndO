package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangleManager {

  /**
   * private constructor to prevent instantiation
   */
  private RectangleManager() {
  }

  /**
   * deletes a rectangle object from list of rectangle objects with user input
   * @param rectangleList list of rectangles to remove a rectangle object from
   */
  static void deleteRectangle(ArrayList<Rectangle> rectangleList) {
    Scanner myScanner = new Scanner(System.in);
    if (rectangleList.isEmpty()) {
      System.out.println("no items to delete");
      return;
    }
    int y = 1;
    System.out.println("Which rectangle would you like to delete:");
    for (; y - 1 < rectangleList.size(); y++) {
      System.out.printf("%s  %s%n", y, rectangleList.get(y - 1).name);
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= y - 1));
    rectangleList.remove(choice - 1);
  }

  /**
   * makes a new rectangle object with user input
   * @return new rectangle object
   */
  static Rectangle addRectangle() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter a name for your new rectangle");
    String name = myScanner.nextLine();

    System.out.println("please enter rectangle width");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int length = myScanner.nextInt();
    myScanner.nextLine();

    System.out.println("please enter rectangle length");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int width = myScanner.nextInt();

    return new Rectangle(name, length, width);
  }
}
