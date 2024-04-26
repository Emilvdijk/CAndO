package nl.emilvdijk;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape {
  protected String name;

  protected Shape(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  abstract double calcSurfaceArea();

  abstract double calcCircumference();

  /**
   * calculates distance between poles in a fence of a rectangle object
   *
   * @param poles amount of poles in rectangle object fence
   * @return distance between poles
   */
  double calcPoleDistance(int poles) {
    return (this.calcCircumference() / poles);
  }

  /**
   * calculates amount of poles in a fence of a rectangle object
   *
   * @param poleDistance distance between poles in rectangle object fence
   * @return amount of poles
   */
  int calcPoleAmount(double poleDistance) {
    return (int) (this.calcCircumference() / poleDistance);
  }


  abstract void printer();

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

  static int chooseNumber(Scanner myScanner){
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int chosenNumber = myScanner.nextInt();
    myScanner.nextLine();
    return chosenNumber;
  }

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
