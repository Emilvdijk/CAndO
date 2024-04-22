package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

public class CircleManager {

  static final ArrayList<Circle> circleList = new ArrayList<>();

  /**
   * private constructor to prevent instantiation
   */
  private CircleManager() {
  }

  /**
   * deletes a circle object from list of circle objects with user input
   * @param circleList list to choose a circle object from and delete it
   */
  static void deleteCircle(ArrayList<Circle> circleList) {
    Scanner myScanner = new Scanner(System.in);
    if (circleList.isEmpty()) {
      System.out.println("no items to delete");
      return;
    }

    System.out.println("Which circle would you like to delete:");
    for (int y = 1; y - 1 < circleList.size(); y++) {
      System.out.printf("%s  %s%n", y, circleList.get(y - 1).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= circleList.size()));
    circleList.remove(choice - 1);
  }

  /**
   * makes a new circle object with user input
   * @return new circle object
   */
  static Circle addCircle() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter a name for your new circle");
    String name = myScanner.nextLine();

    System.out.println("please enter circle radius (can be a decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    double radius = myScanner.nextDouble();
    myScanner.nextLine();

    return new Circle(name, radius);
  }
}
