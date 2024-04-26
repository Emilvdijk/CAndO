package nl.emilvdijk;

import java.util.Scanner;

public class CircleMenu {

  /**
   * private constructor to prevent instantiation
   */
  private CircleMenu() {
  }

  /**
   * looping menu that asks user input and advances chosen option
   */
  static void menu(Scanner myScanner) {
    System.out.println("Circle Manager");
    while (true) {
      System.out.println("""
          1 list Circle
          2 Create new Circle
          3 Remove Circle
          4 Calculate circumference
          5 Calculate circumference of an object
          6 Calculate Surface area
          7 Calculate Surface area of an object
          8 Calculate distance between fence poles based on amount of poles of an object
          9 Calculate amount of fence poles based on distance between poles of an object
          0 back
          """);

      while (!myScanner.hasNextInt()) {
        System.out.println("Please enter a number to choose.");
        myScanner.next();
      }

      switch (myScanner.nextLine()) {
        case "1":
          circleListPrinter();
          break;

        case "2":
          CircleManager.circleList.add(CircleManager.addCircle());
          break;

        case "3":
          CircleManager.deleteCircle(CircleManager.circleList);
          break;

        case "4":
          circumferenceCalc();
          break;

        case "5":
          circumferenceOfCircleCalc();
          break;

        case "6":
          surfaceAreaCalc();
          break;

        case "7":
          surfaceAreaOfCircleCalc();
          break;

        case "8":
          calcPoleDistanceOfCircle();
          break;

        case "9":
          calcPoleAmountOfCircle();
          break;

        case "0":
          return;

        default:
          System.out.println("Please enter a number to choose.");
      }
    }
  }

  /**
   * prints out all circle item details
   */
  private static void circleListPrinter() {
    if (CircleManager.circleList.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Circle circle : CircleManager.circleList) {
      System.out.println(circle.toFormattedString());
    }
  }

  /**
   * asks user input for circle object and prints out circumference of chosen circle object
   */
  private static void circumferenceOfCircleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (CircleManager.circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate circumference of");
    for (int y = 0; y < CircleManager.circleList.size(); y++) {
      System.out.printf(" %s  %s%n", y + 1, CircleManager.circleList.get(y).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= CircleManager.circleList.size()));
    System.out.printf("circumference of %s is: %s", CircleManager.circleList.get(choice - 1).getName(),
        CircleManager.circleList.get(choice - 1).calcCircumference());
  }

  /**
   * asks user for radius of circle and prints out circumference of circle
   */
  private static void circumferenceCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter radius (can be a decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    double radius = myScanner.nextDouble();
    System.out.printf("circumference is: %s", Circle.calcCircumference(radius));
  }

  /**
   * asks user to choose a circle object and prints out surface area of chosen object
   */
  private static void surfaceAreaOfCircleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (CircleManager.circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate surface area of");

    for (int y = 0; y < CircleManager.circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, CircleManager.circleList.get(y).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= CircleManager.circleList.size()));
    System.out.printf("surface area of %s is: %s", CircleManager.circleList.get(choice - 1).getName(),
        CircleManager.circleList.get(choice - 1).calcSurfaceArea());

  }

  /**
   * asks user input for a radius and prints out surface area of circle with chosen radius
   */
  private static void surfaceAreaCalc() {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("please enter radius (can be decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number");
      myScanner.next();
    }
    double radius = myScanner.nextDouble();
    System.out.printf("surface area is: %s", Circle.calcSurfaceArea(radius));
  }

  /**
   * asks user to choose circle object from list and amount of poles after which it will print out
   * amount of poles in a fence of chosen circle object
   */
  private static void calcPoleAmountOfCircle() {
    Scanner myScanner = new Scanner(System.in);
    if (CircleManager.circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate amount of poles");

    for (int y = 0; y < CircleManager.circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, CircleManager.circleList.get(y).getName());
    }
    int choiceRectangle;
    do {
      choiceRectangle = myScanner.nextInt();
    } while (!(choiceRectangle >= 1 && choiceRectangle <= CircleManager.circleList.size()));

    System.out.println("enter the distance between poles (can be decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    double poleDistance=myScanner.nextDouble();
    System.out.printf("amount of poles in the fence around %s is: %s",
        CircleManager.circleList.get(choiceRectangle - 1).getName(),
        CircleManager.circleList.get(choiceRectangle - 1).calcPoleAmount(poleDistance));
  }

  /**
   * asks input and calculates amount of poles needed in a circle object fence and prints it out
   */
  private static void calcPoleDistanceOfCircle() {
    Scanner myScanner = new Scanner(System.in);
    if (CircleManager.circleList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select circle to calculate distance between poles");

    for (int y = 0; y < CircleManager.circleList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, CircleManager.circleList.get(y).getName());
    }
    int choiceCircle;
    do {
      choiceCircle = myScanner.nextInt();
    } while (!(choiceCircle >= 1 && choiceCircle <= CircleManager.circleList.size()));

    System.out.println("how many poles are in the fence");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int amountOfPoles= myScanner.nextInt();
    System.out.printf("distance between poles of %s is: %s",
        CircleManager.circleList.get(choiceCircle - 1).getName(),
        CircleManager.circleList.get(choiceCircle - 1).calcPoleDistance(amountOfPoles));
  }

}
