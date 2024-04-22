package nl.emilvdijk;

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
  static void menu() {
    System.out.println("Rectangles Manager");
    Scanner myScanner = new Scanner(System.in);
    while (true) {
      System.out.println("""
          1 list rectangles
          2 Create new rectangle
          3 Remove rectangle
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
          rectangleListPrinter();
          break;

        case "2":
          RectangleManager.rectanglesList.add(RectangleManager.addRectangle());
          break;

        case "3":
          RectangleManager.deleteRectangle(RectangleManager.rectanglesList);
          break;

        case "4":
          circumferenceCalc();
          break;

        case "5":
          circumferenceOfRectangleCalc();
          break;

        case "6":
          surfaceAreaCalc();
          break;

        case "7":
          surfaceAreaOfRectangleCalc();
          break;

        case "8":
          calcPoleDistanceOfRectangle();
          break;

        case "9":
          calcPoleAmountOfRectangle();
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
    if (RectangleManager.rectanglesList.isEmpty()) {
      System.out.println("no items to show");
      return;
    }
    for (Rectangle rectangle : RectangleManager.rectanglesList) {
      rectangle.rectanglePrinter();
    }
  }

  /**
   * asks user to choose a rectangle object and prints out its circumference
   */
  private static void circumferenceOfRectangleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (RectangleManager.rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate circumference of");

    for (int y = 0; y < RectangleManager.rectanglesList.size(); y++) {
      System.out.printf(" %s  %s%n", y + 1, RectangleManager.rectanglesList.get(y).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= RectangleManager.rectanglesList.size()));
    System.out.printf("circumference of %s is: %s", RectangleManager.rectanglesList.get(choice - 1).getName(),
        RectangleManager.rectanglesList.get(choice - 1).calcCircumference());
  }

  /**
   * asks user for a length and width and prints out its circumference
   */
  private static void circumferenceCalc() {
    Scanner myScanner = new Scanner(System.in);
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
    System.out.printf("circumference is: %s", Rectangle.calcCircumference(length, width));
  }

  /**
   * asks user to select a rectangle object and prints out its surface area
   */
  private static void surfaceAreaOfRectangleCalc() {
    Scanner myScanner = new Scanner(System.in);
    if (RectangleManager.rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate surface area of");

    for (int y = 0; y < RectangleManager.rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, RectangleManager.rectanglesList.get(y).getName());
    }
    int choice;
    do {
      choice = myScanner.nextInt();
    } while (!(choice >= 1 && choice <= RectangleManager.rectanglesList.size()));
    System.out.printf("surface area of %s is: %s", RectangleManager.rectanglesList.get(choice - 1).getName(),
        RectangleManager.rectanglesList.get(choice - 1).calcSurfaceArea());

  }

  /**
   * asks user for a length and width to calculate surface area of and prints out result
   */
  private static void surfaceAreaCalc() {
    Scanner myScanner = new Scanner(System.in);
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
    System.out.printf("surface area is: %s", Rectangle.calcSurfaceArea(length, width));
  }



  /**
   *asks user to select a rectangle object and distance between poles and prints out the amount of poles
   */
  private static void calcPoleAmountOfRectangle() {
    Scanner myScanner = new Scanner(System.in);
    if (RectangleManager.rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate amount of poles");

    for (int y = 0; y < RectangleManager.rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, RectangleManager.rectanglesList.get(y).getName());
    }
    int choiceRectangle;
    do {
      choiceRectangle = myScanner.nextInt();
    } while (!(choiceRectangle >= 1 && choiceRectangle <= RectangleManager.rectanglesList.size()));

    System.out.println("enter the distance between poles (can be decimal number)");
    while (!myScanner.hasNextDouble()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    double poleDistance=myScanner.nextDouble();
    System.out.printf("amount of poles in the fence around %s is: %s",
        RectangleManager.rectanglesList.get(choiceRectangle - 1).getName(),
        RectangleManager.rectanglesList.get(choiceRectangle - 1).calcPoleAmount(poleDistance));
  }

  /**
   * asks user to select a rectangle object and an amount of poles and prints out distance between poles
   */
  private static void calcPoleDistanceOfRectangle() {
    Scanner myScanner = new Scanner(System.in);
    if (RectangleManager.rectanglesList.isEmpty()) {
      System.out.println("no items to calculate with");
      return;
    }
    System.out.println("please select rectangle to calculate distance between poles");

    for (int y = 0; y < RectangleManager.rectanglesList.size(); y++) {
      System.out.printf("%s  %s%n", y + 1, RectangleManager.rectanglesList.get(y).getName());
    }
    int choiceRectangle;
    do {
      choiceRectangle = myScanner.nextInt();
    } while (!(choiceRectangle >= 1 && choiceRectangle <= RectangleManager.rectanglesList.size()));

    System.out.println("how many poles are in the fence");
    while (!myScanner.hasNextInt()) {
      System.out.println("Please enter a number to choose.");
      myScanner.next();
    }
    int amountOfPoles= myScanner.nextInt();
    System.out.printf("distance between poles of %s is: %s",
        RectangleManager.rectanglesList.get(choiceRectangle - 1).getName(),
        RectangleManager.rectanglesList.get(choiceRectangle - 1).calcPoleDistance(amountOfPoles));
  }

}
